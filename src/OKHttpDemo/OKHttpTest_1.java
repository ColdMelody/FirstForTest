package OKHttpDemo;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;

/**
 * Created by Bill on 2016/4/22.
 * synchronous Get
 * The string() method on response body is convenient and efficient for small documents.
 * <p>But if the response body is large (greater than 1 MiB),
 * <p>avoid string() because it will load the entire document into memory. In that case, prefer to process the body as a stream.</p>
 */
public class OKHttpTest_1 {
    private final OkHttpClient okHttpClient = new OkHttpClient();

    public void run() throws IOException {
        Request request = new Request.Builder()
                .url("http://desk.fd.zol-img.com.cn/t_s2560x1600c5/g5/M00/02/04/ChMkJ1bKx66IcGDZABGrxS9bh2wAALH3QBwFjcAEavd404.jpg")
                .build();
        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful())
            throw new IOException("Unexpected code" + response);
        Headers headers = response.headers();
        for (int i = 0; i < headers.size(); i++)
            System.out.println(headers.name(i) + ": " + headers.value(i));
        System.out.println(response.body().string());
    }

    public static void main(String[] args) throws IOException {
        new OKHttpTest_1().run();
    }
}
