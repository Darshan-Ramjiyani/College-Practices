<%-- Document : index | Created on : Apr 3, 2022, 9:44:57 AM | Author : DSP --%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.ResultSet,DBandSession.UserTable,DBandSession.User"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8" />
        <title>Login | Dwiadh</title>
        <meta
            name="viewport"
            content="width=device-width,initial-scale=1, maximum-scale=1,
            user-scalable=no"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.1/css/bootstrap.min.css"
            />
        <link rel="stylesheet" href="Styles/styles.css" />
    </head>
    <body class="d-flex flex-row">
        <div class="container my-auto">
            <div class="row">
                <div class="col-12 ">
                    <p class="h1 text-center text-danger mb-2">Sign in</p>
                </div>
            </div>

            <% 
                  String error = request.getParameter("error");
                  if( error != null )
                  {
                      out.println("<div class='row d-flex justify-content-center'><div class='col-md-5 col-12 alert alert-danger text-center m-0'>"+error+"</div></div>");
                  }
            %>

            <div class="row justify-content-center align-items-center px-2">
                <div class="col-md-4 col-12 p-3 justify-items-space-evenly">
                    <form name="signinForm method="POST" action="Verifier">
                        <div class="form-group">
                            <label for="signinFormUsername" class="text-light"
                                   >Username</label
                            >

                            <input
                                type="text"
                                class="form-control"
                                name="signinFormUsername"
                                placeholder="Enter username"
                                />
                        </div>

                        <div class="form-group">
                            <label for="signinFormPassword" class="text-light"
                                   >Password</label
                            >

                            <input
                                type="password"
                                class="form-control"
                                name="signinFormPassword"
                                placeholder="Enter password"
                                />
                        </div>
                        <div class="form-group form-check">
                            <input type="checkbox" class="form-check-input" id="rememberMe" />

                            <label class="form-check-label text-light" for="rememberMe"
                                   >Remember me</label
                            >
                        </div>

                        <input
                            type="submit"
                            class="btn btn-danger w-100"
                            name="action"
                            value="Signin"
                            />

                        <div class="form-group py-2 text-center">
                            <a href="signup.jsp" id="signupFormLink"
                               >Have not registered yet? Click to register.</a
                            >
                        </div>
                    </form>
                </div>
                <div class="col-md-4 col-12 p-3 justify-content-center">
                    <lottie-player
                        src="resources\signin-animation.json"
                        background="transparent"
                        speed="1"
                        loop
                        autoplay
                        ></lottie-player>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-12">
                    <p class="h6 text-center text-light">
                        &COPY; DSP. All rights reserved.
                    </p>
                </div>
            </div>
        </div>
    </body>
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
</html>
