// pages/start/start.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    /**
     * 判断石油已经授权——storage里面有key（userInfo）
     */
    wx.getStorage({
      key:"userInfo",
      success:function(res){
        /**
         * 如果已经授权，则直接跳转到首页
         */
        wx.switchTab({
          url:'/pages/index/index'
        })
      }
    })

  },
  /**
   * 触发授权获取用户信息的事件
   */
  getUserProfile:function(){
     // 推荐使用 wx.getUserProfile 获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认
    // 开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '用于完善会员资料', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: function(res){
        console.log(res.userInfo)
        // 缓存到本地
        wx.setStorage({
          key:"userInfo",
          data:res.userInfo
        })

        wx.switchTab({
          url:'/pages/index/index'
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