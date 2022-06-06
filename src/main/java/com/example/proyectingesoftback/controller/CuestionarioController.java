package com.example.proyectingesoftback.controller;

import com.example.proyectingesoftback.model.Cuestionario;
import com.example.proyectingesoftback.model.Pregunta;
import com.example.proyectingesoftback.model.Respuesta;
import com.example.proyectingesoftback.model.User;
import com.example.proyectingesoftback.repository.CuestionarioRepository;
import com.example.proyectingesoftback.repository.PreguntaRepository;
import com.example.proyectingesoftback.repository.RespuestaRepository;
import com.example.proyectingesoftback.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController // Defines that this class is a spring bean
@Api(tags = {"Class: CuestionarioController"})
@RequestMapping("/parcial/v1/")
public class CuestionarioController {


    // Tells the application context to inject an instance of BookRespository here
    @Autowired
    private CuestionarioRepository cuestionarioRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping("/cuestionarios")
    @ApiOperation(value = "*** Service Method Get All Casos ***", notes = "*** Get All Casos from MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get All Casos!!! ***")})
    public List<Cuestionario> getAllCasos() {
        // The BookRepository is already injected and you can use it

        return cuestionarioRepository.findAll();
    }


    @GetMapping("/cuestionario/{id}")
    @ApiOperation(value = "*** Service Method Get cuestionario by Id ***", notes = "*** Get from MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error Get Caso!!! ***")})
    public Cuestionario getCuestionarioById(@PathVariable Integer id) {
        Cuestionario cuestionario =  cuestionarioRepository.findById(id).get();
        System.out.println(cuestionario);
        return cuestionario;
    }

    @PostMapping("/cuestionario")
    @ApiOperation(value = "*** Service Method Post New cuestionario ***", notes = "*** Create New cuestionario into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error ***")})
    public Cuestionario createCustionario(@RequestBody Cuestionario cuestionario) {
        return cuestionarioRepository.save(cuestionario);
    }

    @PostMapping("/pregunta")
    @ApiOperation(value = "*** Service Method Post New Caso ***", notes = "*** Create New Caso into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error ***")})
    public Pregunta createPregunta(@RequestBody Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @PostMapping("/respuesta")
    @ApiOperation(value = "*** Service Method Post New cuestionario ***", notes = "*** Create New cuestionario into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Error ***")})
    public Respuesta createRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @PutMapping("/cuestionarios/{id}")
    @ApiOperation(value = "*** Service Method Put Caso ***", notes = "*** Update Caso into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Update Error  ***")})
    public Cuestionario updateCuestionario(@PathVariable Integer id, @RequestBody Cuestionario cuestionarioNew) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id).get();

        cuestionario.setPreguntas(cuestionarioNew.getPreguntas());

        cuestionarioRepository.save(cuestionario);
        return cuestionario;
    }

    @DeleteMapping("/cuestionario/{id}")
    @ApiOperation(value = "*** Service Method Delete Caso ***", notes = "*** Delete Caso from MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Delete Error - CasoId ***")})
    public Cuestionario deleteCuestionario(@PathVariable Integer id) {
        Cuestionario cuestionario = cuestionarioRepository.findById(id).get();
        cuestionarioRepository.deleteById(id);
        return cuestionario;
    }

    //Query
    @GetMapping("/cuestionarios/{UserId}")
    @ApiOperation(value = "*** Service Method Get All Casos from User ***", notes = "*** Get All Casos from UserID\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Get Error - UserID not Found  ***")})
    public Cuestionario getfindByUserId(@PathVariable Integer UserId) {
        return cuestionarioRepository.findById(UserId).get();
    }


    //Load List of Books
    @PostMapping("/cuestionarios")
    @ApiOperation(value = "*** Service Method Post List of Casos ***", notes = "***  Post List of Casos into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Put Error ***")})
    public String createCuestionarioList(@RequestBody List<Cuestionario> cuestionarios) {
        cuestionarioRepository.saveAll(cuestionarios);
        return "done";
    }

    @PutMapping("/cuestionario/{idUsuario}/{idCuestionario}/{idPregunta}")
    @ApiOperation(value = "*** Service Method Put to associate ***", notes = "***  Associate Caso with User into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Put Error - UserID or CasoId not found ***")})
    public Cuestionario associateUserCuestionarioPregunta(@PathVariable int idUsuario, @PathVariable int idCuestionario, @PathVariable int idPregunta) {

        User user = userRepository.findById(idUsuario).get();
        Cuestionario cuestionario = cuestionarioRepository.findById(idCuestionario).get();
        Pregunta pregunta = preguntaRepository.findById(idPregunta).get();

        cuestionario.setUser(user);
        pregunta.setCuestionario(cuestionario);

        cuestionarioRepository.save(cuestionario);
        return cuestionario;
    }

    @PutMapping("/respuesta/{idPregunta}/{idRepuesta}")
    @ApiOperation(value = "*** Service Method Put to associate ***", notes = "***  Associate Caso with User into MySQL\\\\WebApp ***")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "*** Put Error - UserID or CasoId not found ***")})
    public Respuesta associatePreguntaRespuesta(@PathVariable int idPregunta, @PathVariable int idRepuesta) {

        Pregunta pregunta = preguntaRepository.findById(idPregunta).get();
        Respuesta respuesta = respuestaRepository.findById(idRepuesta).get();

        respuesta.setPregunta(pregunta);

        respuestaRepository.save(respuesta);
        return respuesta;
    }
}
