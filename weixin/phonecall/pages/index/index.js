// pages/index/index.js
Page({
    call(event){
        console.log(event);
        var phoneNumber = event.target.id;
        console.log(phoneNumber);

        // 调用微信小程序的打电话功能
        wx.makePhoneCall({
            phoneNumber: phoneNumber
        })
    }
})