package com.porfolio.api.Dao;

import com.porfolio.api.Models.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class ProjectDao implements ProjectInterfaceDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Project> getProjects() {
        String query = "FROM Project";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Project getProject(Long id) {

        Project project = entityManager.find(Project.class, id);

        return project;
    }

    @Override
    public Project newProject(Project project) {

        try {
            Project projectDB = entityManager.merge(project);
            return projectDB;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteProject(Long id) {

        try {
            Project project = entityManager.find(Project.class, id);
            entityManager.remove(project);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updataProject(Project project) {
        try{

            Project newProject = new Project();
            newProject.setId(project.getId());
            newProject.setTitle(project.getTitle());
            newProject.setUrl_Img(project.getUrl_Img());
            newProject.setUrl_Git(project.getUrl_Git());
            entityManager.merge(newProject);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
