// pages/list/list.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        phoneList:[
            {
                photo:"/photos/my.png",
                name: "范振辉",
                phoneNum: 18021338414
            },
            {
                photo: "/photos/my.png",
                name: "王瑞",
                phoneNum: 18013007327
            },
            {
                photo: "/photos/my.png",
                name: "中国电信",
                phoneNum: 10000
            },
            {
                photo: "/photos/my.png",
                name: "中国移动",
                phoneNum: 10086
            },
            {
                photo: "/photos/my.png",
                name: "中国联通",
                phoneNum: 10010
            }
            
        ]
       
    },
    call(event){
        console.log("--------------------")
        console.log(event);
        var phoneNum = event.target.id;
        // 微信小程序，提供了打电话系统功能
        wx.makePhoneCall({
            phoneNumber: phoneNum,
            success:function(){
                console.log("------------电话拨打成功。。-----------")
            }
        })
    }

 
})