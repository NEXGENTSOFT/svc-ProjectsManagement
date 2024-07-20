package com.example.projectsmanagement.src.ProjectsManagement.Application.UseCase.ProjectsUseCase;

import com.example.projectsmanagement.src.ProjectsManagement.Domain.Entity.Projects;
import com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.DTOS.Requests.CreateProjectsRequest;
import com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.DTOS.Responses.BaseResponse;
import com.example.projectsmanagement.src.ProjectsManagement.Infrastructure.Repositories.MySQLRepositories.MySQLProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProjectsUseCase {
    @Autowired
    MySQLProjectsRepository repository;

    public BaseResponse run(CreateProjectsRequest request){
        Projects project = new Projects(request.getName(), request.getDescription());
        return repository.addProject(project);
    }
}