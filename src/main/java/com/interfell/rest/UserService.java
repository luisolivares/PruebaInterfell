package com.interfell.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.interfell.rest.util.UtilBase;
import com.rest.rest.bean.AnswerMessage;
import com.rest.rest.bean.Usuario;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/users/")
@Api(value = "/users", description = "Operaciones con usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UserService extends UtilBase{

	@POST
	@Path("/saludos")
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Da de alta un nuevo usuario", notes = "Crea un nuevo usuario a partir de un ID y un nombre. El usuario no debe existir")
	public Response login() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setEmail("luisolivares8@hotmail.com");
		usuario.setContraseña("123456");
		return Response.status(200).entity(usuario).build();

	}

	@DELETE
	@Path("/numero/{numero}")
	@ApiOperation(value = "Obtiene un mensaje.", response = AnswerMessage.class, httpMethod = "GET", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, notes = "Servicio que retorna un mensaje.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Respuesta exitosa exitosa.", response = AnswerMessage.class),
			@ApiResponse(code = 400, message = "No llegó número.") })
	public Response getAnswerMessage(
			@ApiParam(required = true, value = "Número cualquiera.", name = "numero") @PathParam("numero") Integer numero) {
		AnswerMessage answerMessage = new AnswerMessage();

		if (numero == null) {
			answerMessage.setNumber(0);
			answerMessage.setMessage("Se espera número");

			return Response.status(Status.BAD_REQUEST).entity(answerMessage)
					.build();
		}

		answerMessage.setMessage("Respuesta exitosa.");
		answerMessage.setNumber(numero);

		return Response.ok(answerMessage).build();
	}

	/**
	 * Método encargado de hacer login en el servicio RestFull
	 * 
	 * @param email
	 *            Email o usuario.
	 * @param password
	 *            Contraseña.
	 * @return
	 * **/
	@GET
	@Path("/login/{email}/{password}")
	@ApiOperation(value = "Método para logearse", response = AnswerMessage.class, httpMethod = "GET", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON, notes = "email = email@email.com y password = 123456")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Hola Mundo.", response = AnswerMessage.class),
			@ApiResponse(code = 400, message = "Error 400") })
	public Response login(
			@ApiParam(required = true, value = "Email", name = "email") @PathParam("email") String email,
			@ApiParam(required = true, value = "Password", name = "password") @PathParam("password") String password) {

		AnswerMessage answerMessage = new AnswerMessage();

		if (null != email && null != password) {
			
			if (validarEmail(email)) {

				if (email.equals("email@email.com")
						&& password.equals("123456")) {
					answerMessage.setNumber(200);
					answerMessage.setMessage("Hola Mundo");
					return Response.ok(answerMessage).build();

				} else {
					answerMessage.setNumber(400);
					answerMessage.setMessage("Error 400");
					return Response.status(Status.BAD_REQUEST)
							.entity(answerMessage).build();
				}

			} else {
				answerMessage.setNumber(400);
				answerMessage.setMessage("Error 400");
				return Response.status(Status.BAD_REQUEST)
						.entity(answerMessage).build();
			}
		} else {
			answerMessage.setNumber(400);
			answerMessage.setMessage("Error 400");

			return Response.status(Status.BAD_REQUEST)
					.entity(answerMessage).build();
		}

	}

}
