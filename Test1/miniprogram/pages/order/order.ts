// pages/order/order.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
      httpurl:'http://localhost:82/',
      imageurl:'http://localhost:82/static/',
      project:{},
      date:'2020-09-15',
      time:'09:00'
  },


  /**
   * 
   * 改变日期的函数
   */
  bindDateChange:function(e){
    console.log("日期改变函数：",e)
    this.setData({
      date:e.detail.value
    })
  },

  /**
   * 
   * 改变时间的函数
   */
  bindTimeChange:function(e){
    this.setData({
      time:e.detail.value
    })
  },


/**
 * 确认预约按钮触发事件
 */

formSubmit:function(e){

     var that = this;
     wx.getStorage({
       key:'user',
       success:(res)=>{
         console.log(res)
         //获取成功证明有token,是登录状态,可以预约
         wx.request({
           url:that.data.httpurl + 'order/createOrder',
           data:{
            token: res.data.token,
            proName: that.data.project.proName,
            makeDate: that.data.date+ " "+ that.data.time,
            userName: e.detail.value.username,
            userTell: e.detail.value.usertell,
            information: e.detail.value.information,
            busId: that.data.project.busId,
            proId: that.data.project.id
           },
           success:(result)=> {
             console.log(result)
             if(result.data.code == 3) {
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
  onLoad(option) {
    
    var that = this;
    //请求项目的数据进行页面填充
     wx.request({
       url:that.data.httpurl + 'project/byId',
       data:{
        id:option.proid
       },
       //成功就返回数据
       success:(res)=>{
         that.setData({
           project: res.data.data
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