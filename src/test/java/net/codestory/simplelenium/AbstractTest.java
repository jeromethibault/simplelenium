/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.simplelenium;

import net.codestory.http.WebServer;
import net.codestory.http.routes.Routes;
import org.junit.After;

public abstract class AbstractTest extends SeleniumTest {
  private final WebServer webServer = new WebServer(this::configureTestServer).startOnRandomPort();

  protected String getDefaultBaseUrl() {
    return "http://localhost:" + webServer.port();
  }

  protected abstract void configureTestServer(Routes routes);

  @After
  public void stopWebServer() {
    webServer.stop();
  }
}
