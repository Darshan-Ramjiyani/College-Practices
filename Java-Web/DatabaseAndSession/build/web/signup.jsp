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
              <label for="signinFormUsername" class="text-light"
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
              <label for="signupFormAddress" class="text-light"
                >Address Line</label
              >
              <input
                type="text"
                class="form-control"
                name="signupFormAddress"
                id="signupFormAddress"
                placeholder="Enter Address"
              />
            </div>

            <div class="form-group">
              <label for="signupFormCity" class="text-light"
                >City/Village</label
              >
              <input
                type="text"
                class="form-control"
                name="signupFormCity"
                id="signupFormCity"
                placeholder="Enter City"
              />
            </div>

            <div class="form-group d-flex flex-row justify-content-center">
              <div class="container-fluid no-bg">
                <div class="row">
                  <div class="col-6">
                    <label for="signupFormDistrict" class="text-light"
                      >District</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      name="signupFormDistrict"
                      id="signupFormDistrict"
                      placeholder="Enter District"
                    />
                  </div>
                  <div class="col-6">
                    <label for="signupFormState" class="text-light"
                      >State</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      name="signupFormState"
                      id="signupFormState"
                      placeholder="Enter State"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="form-group d-flex flex-row justify-content-center">
              <div class="container-fluid no-bg">
                <div class="row">
                  <div class="col-6">
                    <label for="signupFormUsername" class="text-light"
                      >Username</label
                    >
                    <input
                      type="text"
                      class="form-control"
                      name="signupFormUsername"
                      id="signupFormUsername"
                      placeholder="Enter Username"
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
            <div class="form-group">
              <label
                for="signupFormAvailaPrefferedDeliveryLocation"
                class="form-label text-light"
                >Preffered Delivery Location</label
              ><br />
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="radio"
                  name="signupFormAvailaPrefferedDeliveryLocation"
                  id="signupFormAvailaPrefferedDeliveryLocationHome"
                  value="Home"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailaPrefferedDeliveryLocationHome"
                  >Home</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="radio"
                  name="signupFormAvailaPrefferedDeliveryLocation"
                  id="signupFormAvailaPrefferedDeliveryLocationOffice"
                  value="option2"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailaPrefferedDeliveryLocationOffice"
                  >Office</label
                >
              </div>
            </div>
            <div class="form-group">
              <label
                for="signupFormAvailableDaysForDelivery"
                class="form-label text-light"
                >Available Days For Delivery</label
              ><br />
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliveryMon"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="mon"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliveryMon"
                  >Mon</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliveryTue"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="tue"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliveryTue"
                  >Tue</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliveryWed"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="wed"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliveryWed"
                  >Wed</label
                >
              </div>
              <div
                class="form-check form-check-inline justify-content-center align-items-center"
              >
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliveryThr"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="thr"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliveryThr"
                  >Thr</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliveryFri"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="fri"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliveryFri"
                  >Fri</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliverySat"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="sat"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliverySat"
                  >Sat</label
                >
              </div>
              <div class="form-check form-check-inline">
                <input
                  class="form-check-input text-danger"
                  type="checkbox"
                  id="signupFormAvailableDaysForDeliverySun"
                  name="signupFormAvailableDaysForDelivery[]"
                  value="sun"
                />
                <label
                  class="form-check-label text-light"
                  for="signupFormAvailableDaysForDeliverySun"
                  >Sun</label
                >
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
