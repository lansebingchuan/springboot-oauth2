package com.zht;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SyBaseApp {

    public static void main(String[] args) {
        SpringApplication.run(SyBaseApp.class, args);
    }

    /**
     * 2021-12-31 16:18:40.900 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.client.service.impl.ParkWechatResult - PARK_ONLINE_PAY == Receiving Charge Result, RecordinId=402881a97e053bd5017e0f6602bf1fc2 ChannelId=402882e97d4c8170017d6f6bd3496d8f
     * 2021-12-31 16:18:40.912 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.park.websocketService.Service.impl.ParkWebsocketServiceImpl - 推送到岗亭，pavilioIP： 192.168.1.220， message: {"data":"{\"msgType\":\"carInfo\",\"msgContent\":{\"carUser\":\"\",\"msgType\":\"carInfo\",\"photoPath\":\"\",\"parkChannelId\":\"402882e97d4c8170017d6f6bd3496d8f\",\"isDiscount\":false,\"manual\":false,\"pavilioName\":\"A区岗亭\",\"isDialog\":true,\"areaName\":\"A区停车场\",\"state\":\"out\",\"event\":\"一般记录\",\"msgInfo\":\"\",\"carTypeName\":\"临时小型车A\",\"recordinTime\":1640935850679,\"recordoutTime\":1640938679193,\"pavilioIP\":\"192.168.1.220\",\"carTypeId\":\"4028e55a7d3bda53017d3bdb28770a11\",\"eventType\":1,\"license\":\"渝A23UU3\",\"port\":0}}","funcId":"CSInfo","key":"111","msgId":"d7ccf158-1bf9-452c-a213-804e3baf986e","ret":1,"ver":"1.0"}
     * 2021-12-31 16:18:40.912 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.park.websocketService.Service.impl.ParkWebsocketServiceImpl - 推送到监控室，comm: {"data":"{\"msgType\":\"carInfo\",\"msgContent\":{\"carUser\":\"\",\"msgType\":\"carInfo\",\"photoPath\":\"\",\"parkChannelId\":\"402882e97d4c8170017d6f6bd3496d8f\",\"isDiscount\":false,\"manual\":false,\"pavilioName\":\"A区岗亭\",\"isDialog\":true,\"areaName\":\"A区停车场\",\"state\":\"out\",\"event\":\"一般记录\",\"msgInfo\":\"\",\"carTypeName\":\"临时小型车A\",\"recordinTime\":1640935850679,\"recordoutTime\":1640938679193,\"pavilioIP\":\"192.168.1.220\",\"carTypeId\":\"4028e55a7d3bda53017d3bdb28770a11\",\"eventType\":1,\"license\":\"渝A23UU3\",\"port\":0}}","funcId":"CSInfo","key":"111","msgId":"d7ccf158-1bf9-452c-a213-804e3baf986e","ret":1,"ver":"1.0"}
     * 2021-12-31 16:18:40.913 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.park.websocketService.ChannelService - PARK_CS == Send Message >>>>> openChannelGate ： {"data":"{\"ChnId\":0,\"NDuration\":\"1000\",\"devIp\":\"192.168.1.200\"}","funcId":"openChannelGate","key":"111","msgId":"7f87d2fb-8169-42c4-8324-da27bcf09419","ret":1,"ver":"1.0"}
     * 2021-12-31 16:18:40.916 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.park.service.impl.Park2LedParamServiceImpl - This method needs to reference the external led module does not exist!!
     * 2021-12-31 16:18:40.916 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.client.service.impl.ParkMessageSendServiceImpl - sendRecordoutMsgs：402881a97e053bd5017e0f912ba4212f
     * 2021-12-31 16:18:40.917 [nioEventLoopGroup-8-3] INFO  com.zkteco.zkbiosecurity.client.service.impl.ParkMessageSendServiceImpl - sendRecordoutMsgs Recordin No Empty ParkRecordoutItem：ParkRecordoutItem(id=402881a97e053bd5017e0f912ba4212f, recordoutLogId=null, sourceDevIp=null, parkPavilioId=402881a97dfb29d1017dfb9169e602eb, parkPavilioName=A区岗亭, parkingAreaId=ff8080817d407f34017d41b0f72f00a9, parkingAreaType=0, parkingAreaName=A区停车场, parkEntranceAreaId=ff8080817d407f34017d464c1d4d01b8, parkEntranceAreaName=A区停车场, userName=, carNumber=渝A23UU3, cardNumber=null, carTypeId=4028e55a7d3bda53017d3bdb28770a11, carTypeCode=tempA, carTypeName=临时小型车A, channelOutName=A区出口, channelOutId=402882e97d4c8170017d6f6bd3496d8f, channelState=2, channelStateNot=null, eventType=1, eventTypeIn=null, recordinId=402881a97e053bd5017e0f6602bf1fc2, checkInTime=2021-12-31 15:30:50.679, checkOutTime=2021-12-31 16:17:59.193, photoPathOut=2021-12-31\192.168.1.200_161759.189_渝A23UU3.jpg, releaseReason=null, timeBegin=null, timeEnd=null, dutyId=4028e55a7d3bda53017d3bdb1c340001, dutyName=admin, workRecordId=402881a97e053bd5017e0f877abd210d)
     */

}
