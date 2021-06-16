/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.http.HttpResponse;
import model.Iris;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

public class PredecirIris {

    public static JSONObject obtenerJSon(Iris modelo) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"Inputs\": {\r\n"
                + "    \"input1\": [\r\n      {\r\n    "
                + "    \"Id\": \"\",\r\n    "
                + "    \"SepalLengthCm\":" + modelo.getSepal_lenght() + ",\r\n    "
                + "    \"SepalWidthCm\":" + modelo.getSepal_width() + ",\r\n    "
                + "    \"PetalLengthCm\":" + modelo.getPetal_lenght() + ",\r\n    "
                + "    \"PetalWidthCm\":" + modelo.getPetal_widht() + ",\r\n    "
                + "    \"Species\": \"\"\r\n   "
                + "   }\r\n    ]\r\n  },\r\n "
                + " \"GlobalParameters\": {}\r\n}");
        Request request = new Request.Builder()
                .url("https://ussouthcentral.services.azureml.net/workspaces/7718e5e06e324618b7a1fd122c0f8354/services/50d76d12cd39443a92fdfdbe5a709aed//execute?api-version=2.0&format=swagger")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer m/wK8ibXVGUDJhKRY8BNnXTZXs2q4PdGY4eA5ofOrz08dpLxMtf2klic9vcLkzVAw2wmaDp9r0RS7sIUAAjghA==")
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "32b5cae4-6f05-fc63-f3e1-9a294e4ae878")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }
        Gson gson = new Gson();
        // Convierte la cadena body en un objeto jsonObject
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject cadenaJson = jsonObject.getJSONObject("Results")
                .getJSONArray("output1")
                .getJSONObject(0);
        return cadenaJson;
    }
}
