package org.asanka.service;

import org.asanka.controller.StudentDaoImpl;
import org.asanka.dao.StudentDao;
import org.asanka.model.Student;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by asankav on 12/30/16.
 */

@Path("/Students/v1.0.0")
public class StudentService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("id") int id) {
        StudentDao studentDao=new StudentDaoImpl();
        Student student=studentDao.getStudent(id);


        return "Hello  to StudentService"+student.toString()+" \n";
    }

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String post(){

        return "Added User to the DB";
    }

}
