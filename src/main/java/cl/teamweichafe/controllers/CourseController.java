package cl.teamweichafe.controllers;

import cl.teamweichafe.common.dtos.CourseDto;
import cl.teamweichafe.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Request Succeeded",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = CourseDto.class)) }),
        @ApiResponse(responseCode = "201", description = "Resource Created",
                content = { @Content(mediaType = "application/json",
                        schema = @Schema(implementation = CourseDto.class)) }),
        @ApiResponse(responseCode = "400", description = "Bad Request",
                content = @Content),
        @ApiResponse(responseCode = "404", description = "Not Found",
                content = @Content) ,
        @ApiResponse(responseCode = "500", description = "Internal Server Error",
                content = @Content)})
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Endpoint to add a course")
    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto courseDto) {

        return ResponseEntity.ok(this.courseService.saveCourse(courseDto));
    }

    @Operation(summary = "Endpoint to get a course by id")
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable String id) {

        return ResponseEntity.ok(this.courseService.getById(id));
    }

    @Operation(summary = "Endpoint to update a course by id")
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable String id, @RequestBody CourseDto courseDto) {

        return ResponseEntity.ok(this.courseService.updateCourse(id, courseDto));
    }

    @Operation(summary = "Endpoint to get all courses")
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAll() {

        return ResponseEntity.ok(this.courseService.getAllCourses());
    }

    @Operation(summary = "Endpoint to delete a course by id")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        this.courseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
