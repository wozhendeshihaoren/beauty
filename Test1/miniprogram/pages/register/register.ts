// pages/register/register.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
       httpurl:"http://localhost:82/"
  },


  /**
   * 跳转到登录页面
   *
   */
  toLogins:()=> {
    wx.navigateTo({
      url:"/pages/logins/logins"
    })
  },
/**
 * 
 */
formSubmit:function(e){
  var that = this;
  /*
   *  获取缓存内容
   */
  console.log(e)
  wx.getStorage({
    key:"userInfo",
    success:function(res){

      wx.request({
        url:that.data.httpurl+"user/register",
        data:{
          // 实体传参时参数传递的key要和实体类的属性名称保持一致
          nickName:res.data.nickName,
          imageURL:res.data.avatarUrl,
          username:e.detail.value.username,
          phone:e.detail.value.phone,
          password:e.detail.value.password
        },
        method:'POST',
        header:{
          // 发送post请求的时候header必须改成这个值，否则接收不到参数
          'content-type': 'application/x-www-form-urlencoded'
        },
        success:function(result){
          console.log("注册返回结果",result.data.message);
          if(result.data.code == 1){
            // 提示
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