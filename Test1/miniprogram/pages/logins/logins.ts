// pages/logins/logins.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httpurl:'http://localhost:82/'

  },
   /**
    * 跳转到注册账号的页面
    */

 toRegister:()=> {
   wx.navigateTo({
     url:"/pages/register/register"
   })
 },


 /**
  * 判断是否登录成功
  */

 formSubmit:function(e){
  var that = this;
      wx.login({
        success (res) {
          if (res.code) {
            //发起网络请求
            wx.request({
              url: that.data.httpurl+"user/login",
              data: {
                code: res.code,
                phone: e.detail.value.phone,
                password: e.detail.value.password,
              },
              method:'POST',
              header:{
                // 发送post请求的时候header必须改成这个值，否则接收不到参数
                'content-type': 'application/x-www-form-urlencoded'
              },
              success:function(result){
                console.log(result)
                if(result.data.code == 2){
                  // 提示
                  wx.setStorage({
                    key: 'user',
                    data: result.data.data
                  })
                  wx.showToast({
                    title: result.data.message,
                    icon: 'success',
                    duration: 2000
                  })
                  // 跳转
                  setTimeout(() => {
                    wx.switchTab({
                      url: '/pages/index/index'
                    })
                  }, 2000);
                }
              }
            })
          } else {
            console.log('登录失败！' + res.errMsg)
          }
        }
      })
  
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})