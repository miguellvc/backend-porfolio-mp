package com.porfolio.api.Dao;

import com.porfolio.api.Models.Project;

import java.util.List;

public interface ProjectInterfaceDao {
    List<Project> getProjects();
    Project getProject(Long id);
    Project newProject(Project project);
    boolean deleteProject(Long id);
    boolean updataProject(Project project);
}
