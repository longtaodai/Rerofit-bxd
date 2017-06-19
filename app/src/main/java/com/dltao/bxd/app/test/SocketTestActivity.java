package com.dltao.bxd.app.test;

import android.util.Log;
import android.widget.Toast;

import com.dltao.bxd.R;
import com.dltao.bxd.app.pages.activity.BaseActivity;
import com.dltao.bxd.mina.client.ClientConfig;
import com.dltao.bxd.mina.client.MinaClient;

/**
 * Created by ui on 2017/6/10.
 */
public class SocketTestActivity extends BaseActivity{

    private final static String TAG = SocketTestActivity.class.getSimpleName();
    private MinaClient minaClient;

    @Override
    protected void initView() {
        setContentView(R.layout.socket_test_activity);
        initClient();
    }


    //测试数据，具体根据通信协议来发送数据，这里只是模拟
    private byte[]  sendData={(byte)0x32,(byte)0x00,(byte)0xf1,(byte)0x80,(byte)0x11,(byte)0x53,(byte)0xa4,(byte)0xf1,(byte)0xfe,(byte)0xaf,
            (byte)0x27,(byte)0x05,(byte)0x61,(byte)0x64,(byte)0x6d,(byte)0x69,(byte)0x6e,(byte)0x20,(byte)0x32,(byte)0x31,(byte)0x32,(byte)0x33,(byte)0x32,(byte)0x66,(byte)0x32,(byte)0x39,(byte)0x37,
            (byte)0x61,(byte)0x35,(byte)0x37,(byte)0x61,(byte)0x35,(byte)0x61,(byte)0x37,(byte)0x34,(byte)0x33,(byte)0x38,(byte)0x39,(byte)0x34,
            (byte)0x61,(byte)0x30,(byte)0x65,(byte)0x34,(byte)0x61,(byte)0x38,(byte)0x30,(byte)0x31,(byte)0x66,(byte)0x63,(byte)0x33};


    private void initClient() {
        //具体填写服务器的id地址以及端口
        ClientConfig clientConfig = new ClientConfig.Builder().setIp("http://www.baidu.com").setPort(9090).build();
//        ClientConfig clientConfig = new ClientConfig.Builder().setIp("192.168.2.77").setPort(3725).build();
        minaClient = new MinaClient(clientConfig);
        minaClient.setClientStateListener(new MinaClient.ClientStateListener() {
            @Override
            public void sessionCreated() {
                Log.d(TAG, "client sessionCreated ");
                Toast.makeText(SocketTestActivity.this,"开始创建连接",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void sessionOpened() {
                Log.d(TAG, "client sessionOpened ");
                Toast.makeText(SocketTestActivity.this,"服务器连接成功",Toast.LENGTH_SHORT).show();
                minaClient.sendMessage(sendData);
            }

            @Override
            public void sessionClosed() {
                Log.d(TAG, "client sessionClosed ");
                Toast.makeText(SocketTestActivity.this,"连接已经断开",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void messageReceived(byte[] message) {
                Log.d(TAG, "client messageReceived " + message.toString());
                Toast.makeText(SocketTestActivity.this,"服务器已经接收到消息",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void messageSent(byte[] message) {
                Log.d(TAG, "client messageSent " + message);
                Toast.makeText(SocketTestActivity.this,"消息发送成功"+message,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
