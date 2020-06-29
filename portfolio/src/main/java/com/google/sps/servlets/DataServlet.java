// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

  private List<String> greetings = new ArrayList<>(Arrays.asList("Bonjour!", "Hello!", "Ni hao!"));

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String greetingsJSON = convertToJson(greetings);
    response.setContentType("application/json;");
    response.getWriter().println(greetingsJSON);
  }

  /**
   * Converts a DataServlet instance into a JSON string using the Gson library. Note: We first added
   * the Gson library dependency to pom.xml.
   */
  private String convertToJson(List<String> data) {
    Gson gson = new Gson();
    String json = gson.toJson(data);
    return json;
  }
}
