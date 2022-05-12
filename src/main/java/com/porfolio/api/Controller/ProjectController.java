package com.porfolio.api.Controller;


import com.porfolio.api.Dao.ProjectInterfaceDao;
import com.porfolio.api.Util.Models.Project;
import com.porfolio.api.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectInterfaceDao projectInterfaceDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/project", method = RequestMethod.GET)
    public List<Project> getAllProject() {
        return projectInterfaceDao.getProjects();
    }

    @RequestMapping(value = "api/project/{id}", method = RequestMethod.GET)
    public Project getProject(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }

        return projectInterfaceDao.getProject(id);

    }


    @RequestMapping(value = "api/project", method = RequestMethod.POST)
    public Project newProject(@RequestHeader(value="x-token") String x_token, @RequestBody Project project) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }

        Project projectDB = projectInterfaceDao.newProject(project);

        if(projectDB !=null) {
            return projectDB;
        }
        return null;
    }

    @RequestMapping(value = "api/project/{id}", method = RequestMethod.DELETE)
    public List<String> deleteProject(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }
        String res;

        if(projectInterfaceDao.deleteProject(id)){
            res = "ok";
        }else{
            res = "error";
        }

        return List.of(res);
    }

    @RequestMapping(value = "api/project", method = RequestMethod.PUT)
    public List<String> updatetProject(@RequestHeader(value="x-token") String x_token, @RequestBody Project project) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }
        String res;

        if(projectInterfaceDao.updataProject(project)){
            res = "ok";
        }else{
            res = "error";
        }

        return List.of(res);
    }
}
