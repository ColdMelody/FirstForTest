package OKHttpDemo;

import okhttp3.*;

import java.io.IOException;

/**
 * Created by Bill on 2016/4/22.
 * <P>Asynchronous Get</P>
 * <p>Download a file on a worker thread, and get called back when the response is readable.
 * The callback is made after the response headers are ready. Reading the response body may still block.
 * OkHttp doesn't currently offer asynchronous APIs to receive a response body in parts.
 *
 */
public class OKHttpTest_2 {
    OkHttpClient client=new OkHttpClient();
    public void run(){
        Request request=new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(!response.isSuccessful())throw new IOException("Unexpected code"+response);
                Headers headers=response.headers();
                for(int i=0;i<headers.size();i++)
                    System.out.println(headers.name(i)+": "+headers.value(i));
                System.out.print(response.body().string());
            }
        });
    }
    public static void main(String[] args){
        new OKHttpTest_2().run();
    }
}
