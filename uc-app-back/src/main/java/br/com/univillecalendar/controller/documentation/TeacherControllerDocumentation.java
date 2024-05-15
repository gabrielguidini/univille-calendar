package br.com.univillecalendar.controller.documentation;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.dto.TeacherFormUpdate;
import br.com.univillecalendar.model.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.UUID;

public interface TeacherControllerDocumentation {
    @Operation(summary = "Create new Teacher")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Create new Teacher",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    TeacherDto createNewTeacher(TeacherDto teacherDto) throws JsonProcessingException;

    @Operation(summary = "Get all teachers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get all teacher",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    List<Teacher> getAllTeachers() throws JsonProcessingException;

    @Operation(summary = "Get teacher by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get teacher by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    Teacher getTeacherById(UUID teacherId) throws JsonProcessingException;

    @Operation(summary = "Get delete teacher by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get delete teacher by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    void deleteTeacher(UUID teacherId) throws JsonProcessingException;

    @Operation(summary = "Get update teacher by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get update teacher by id",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    TeacherDto updateTeacher(UUID teacherId, TeacherFormUpdate teacherFormUpdate) throws JsonProcessingException;

}
