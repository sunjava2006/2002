// pages/call/call.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        
        phoneNumList: [
            {
                name:"王瑞", 
                phone:18013007327, 
                photo:'/imgs/face.png'},
            {
                name: "陈仕", 
                phone: 18360608842, 
                photo: "/imgs/face.png"},
            {
                name: "王翰林",
                phone: 17361988783,
                photo:"/imgs/face.png"},
            {
                name: "陈阳",
                phone: 18351950078,
                photo: "/imgs/face.png"
            },
            {
                name: "王英",
                phone: 18951027870,
                photo: "/imgs/face.png"
            },
            {
                name: "李欣",
                phone: 13913321086,
                photo: "/imgs/face.png"
            }
        ]
    },
    call(event){
        console.log(event);
        /* 取出图片中的id的值。这个值就是电话号码。 */
        var phoneNO = event.target.id;

        /*调用微信的打电话功能*/
        wx.makePhoneCall({
            phoneNumber: phoneNO
        })
    }

    
})