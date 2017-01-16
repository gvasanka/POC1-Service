/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.asanka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.asanka.controller.UserControllerImpl;
import org.asanka.model.User;
import org.wso2.msf4j.Request;
import org.wso2.msf4j.util.BufferUtil;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 0.1-SNAPSHOT
 */
@Path("/users/v1.0.0")
public class UserService {
    UserControllerImpl userController;

//    Get user by Id
    @GET
    @Path("/{id}")
    public String get(@PathParam("id") int id) {

        System.out.println("GET invoked");

        userController=new UserControllerImpl();
        User user=userController.getUserById(id);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json=mapper.writeValueAsString(user);
             return "Hello  to ::  "+json+"\n";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "Hello  to ::  \n";
    }

    @POST
    @Path("/")
    public Response post(@Context Request request){

        System.out.println("POST invoked");
        String data=null;
        try {
             data = getStringContent(request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject object = new JsonObject();
        object.addProperty("Toptag","yes" );
        object.addProperty("result", data);
        object.addProperty("sameresult", data);

        return Response.status(Response.Status.OK).entity(object).build();

    }

    private String getStringContent(Request request) throws IOException {
        return Charset.defaultCharset().decode(BufferUtil.merge(request.getFullMessageBody())).toString();
    }
}
