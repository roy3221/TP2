/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.android10.sample.data.net;

import android.support.annotation.Nullable;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Api Connection class used to retrieve data from the cloud.
 * Implements {@link java.util.concurrent.Callable} so when executed asynchronously can
 * return a value.
 */
public class ApiConnection implements Callable<String> {

  private static final String CONTENT_TYPE_LABEL = "Content-Type";
  private static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";
  public static final MediaType JSON
          = MediaType.parse("application/json; charset=utf-8");

  private URL url;
  private String response;
    private String key;
    private String value;

  private ApiConnection(String url) throws MalformedURLException {
    this.url = new URL(url);
  }

    private ApiConnection(String url, String key, String value) throws MalformedURLException {
        this.url = new URL(url);
        this.key = key;
        this.value = value;
    }

  public static ApiConnection createGET(String url) throws MalformedURLException {
    return new ApiConnection(url);
  }

    public static ApiConnection createGET(String url, String key, String value) throws MalformedURLException {
        return new ApiConnection(url);
    }

  /**
   * Do a request to an api synchronously.
   * It should not be executed in the main thread of the application.
   *
   * @return A string response
   */
  @Nullable
  public String requestSyncCall() {
    connectToApi();
    return response;
  }

    public String requestSyncCallPOST() throws IOException {
        PostToServer();
        return response;
    }


  private void connectToApi() {
    OkHttpClient okHttpClient = this.createClient();
    final Request request = new Request.Builder()
        .url(this.url)
        .addHeader(CONTENT_TYPE_LABEL, CONTENT_TYPE_VALUE_JSON)
        .get()
        .build();

    try {
      this.response = okHttpClient.newCall(request).execute().body().string();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // post to server and get JSON response as a string.
  public void PostToServer() throws IOException{
    OkHttpClient client = new OkHttpClient();
    String json = createKeyValuePair(key, value);
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder()
            .url(url)
            .post(body)
            .build();
    Response response = client.newCall(request).execute();
    this.response = response.body().string();
  }

  // create the key value pair for http post request.
  public String createKeyValuePair(String key, String value) {
    return "{" + key+":"+value+"}";
  }

  private OkHttpClient createClient() {
    final OkHttpClient okHttpClient = new OkHttpClient();
    okHttpClient.setReadTimeout(10000, TimeUnit.MILLISECONDS);
    okHttpClient.setConnectTimeout(15000, TimeUnit.MILLISECONDS);

    return okHttpClient;
  }

  @Override public String call() throws Exception {
    return requestSyncCall();
  }
}
