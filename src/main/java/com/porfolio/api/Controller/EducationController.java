package com.porfolio.api.Controller;

import com.porfolio.api.Dao.EducationInterfaceDao;
import com.porfolio.api.Models.Education;
import com.porfolio.api.Util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController

public class EducationController {

    @Autowired
    private EducationInterfaceDao educationInterfaceDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/education", method = RequestMethod.GET)
    public List<Education> getAllEducation() {

        return educationInterfaceDao.getEducations();
    }

    @RequestMapping(value = "api/education/{id}", method = RequestMethod.GET)
    public Education getEducation(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }
        return educationInterfaceDao.getEducation(id);
    }


    @RequestMapping(value = "api/education", method = RequestMethod.POST)
    public Education newEducación(@RequestHeader(value="x-token") String x_token, @RequestBody Education education) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }

        Education educationDB = educationInterfaceDao.newEducation(education);

        if(educationDB != null) {

            return educationDB;
        }
        return null;
    }

    @RequestMapping(value = "api/education/{id}", method = RequestMethod.DELETE)
    public List<String> deleteEducación(@RequestHeader(value="x-token") String x_token, @PathVariable Long id) {
        if(jwtUtil.getKey(x_token) == null) { return  null; }
        String res;

        if(educationInterfaceDao.deleteEducation(id)) {
            return List.of("ok");
        }
        return List.of("error");
    }


    @RequestMapping(value = "api/education", method = RequestMethod.PUT)
    public List<String> updateEducación(@RequestHeader(value="x-token") String x_token, @RequestBody Education education) {

        if(jwtUtil.getKey(x_token) == null) { return  null; }
        String res;

        if(educationInterfaceDao.updateEducation(education)) {
             res = "ok";
        }else {
            res = "error";
        }

        return List.of(res);
    }

}
