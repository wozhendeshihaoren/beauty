// pages/exit/exit.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    user:{},
    isLogin:false
  },
  /**
   * 点击跳转到注册页面
   */
  toRegister:function(){
    wx.navigateTo({
      url:"/pages/register/register"
    })
  },
  /**
   * 点击跳转到登录页面
   */
  toLogin:function(){
    wx.getStorage({
      key:"user",
      success:function(){
        wx.showToast({
          title: '您已登录！',
          icon: 'error',
          duration: 1500
        })
      },
      fail:function(){
        wx.navigateTo({
          url:"/pages/logins/logins"
        })
      }
    })
  },
  /**
   * 点击跳转到退出页面
   */
  toExit:function(){
    wx.getStorage({
      key:"user",
      success:function(){
        wx.removeStorage({
          key:"user"
        })
        wx.reLaunch({
          url:"/pages/personal/personal"
        })
      },
      fail:function(){
        wx.showToast({
          title: '您未登录！',
          icon: 'error',
          duration: 1500
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    var that = this;
    /**
     * 从缓存中获取userInfo
     */
    wx.getStorage({
      key:"user",
      success:function(res){
        console.log(res.data)
        that.setData({
          user:res.data,
          isLogin:true
        })
      }
    })
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