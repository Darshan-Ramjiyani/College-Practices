<%-- Document : index | Created on : Apr 3, 2022, 9:44:57 AM | Author : DSP --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <div class="col-12">
                    <p class="h1 text-center text-danger">Sign up</p>
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
                <div class="col-md-5 col-12 p-3 justify-content-center">
                    <lottie-player
                        src="./resources/registration-animation.json"
                        background="transparent"
                        speed="0.5"
                        loop
                        autoplay
                        style="height: auto; width: auto"
                        ></lottie-player>
                </div>
                <div class="col-md-5 col-12 p-3 justify-items-space-evenly">
                    <form name="signinForm" method="POST" action="Verifier">
                        <div class="form-group">
                            <label for="signinFormFullName" class="text-light"
                                   >Full Name</label
                            >
                            <input
                                type="text"
                                class="form-control"
                                name="signupFormFullname"
                                id="signupFormFullname"
                                placeholder="Enter Full Name"
                                />
                        </div>

                        <div class="form-group">
                            <label for="signupFormGender" class="text-light"
                                   >Gender</label
                            ><br/>
                            <select class="form-select custom-select" name="signupFormGender">
                                <option value="Male" selected="">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="signupFormDOB" class="text-light"
                                   >Date of Birth</label
                            >
                            <input
                                type="date"
                                class="form-control"
                                name="signupFormDOB"
                                id="signupFormDOB"
                                placeholder="Select Date of Birth"
                                />
                        </div>

                        <div class="form-group d-flex flex-row justify-content-center">
                            <div class="container-fluid no-bg">
                                <div class="row">
                                    <div class="col-6">
                                        <label for="signupFormEmail" class="text-light"
                                               >Email</label
                                        >
                                        <input
                                            type="email"
                                            class="form-control"
                                            name="signupFormEmail"
                                            id="signupFormEmail"
                                            placeholder="Enter Email Address"
                                            />
                                    </div>
                                    <div class="col-6">
                                        <label for="signupFormPassword" class="text-light"
                                               >Password</label
                                        >
                                        <input
                                            type="text"
                                            class="form-control"
                                            name="signupFormPassword"
                                            id="signupFormPassword"
                                            placeholder="Enter Password"
                                            />
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="form-group d-flex flex-row justify-content-center">
                            <input
                                type="submit"
                                class="form-control btn btn-danger flex-item"
                                value="Signup"
                                name="action"
                                />
                            <input
                                type="reset"
                                value="Reset Form"
                                class="form-control btn btn-success flex-item"
                                />
                        </div>
                    </form>
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
