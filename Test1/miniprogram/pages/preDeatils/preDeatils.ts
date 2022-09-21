// pages/preDeatils/preDeatils.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httpurl:'http://localhost:82/',
    imageurl:'http://localhost:82/static/',
    project:{},
    flag:false
  },


/**
 * 点击触发收藏任务
 */

toConProject:function(e){
     console.log(e)
    var that = this;
     wx.request({
       url: that.data.httpurl + 'project/updateFlag',
       data:{
         id: e.currentTarget.dataset.proid,
         flag: true
       },
       success:()=>{
         that.setData({
           flag:true
         })
       }
     })
  },
  toConProject2:function(e){
    console.log(e)
   var that = this;
    wx.request({
      url: that.data.httpurl + 'project/updateFlag',
      data:{
        id: e.currentTarget.dataset.proid,
        flag: false
      },
      success:()=>{
        that.setData({
          flag:false
        })
      }
    })
 },
/**
 * 跳转到订单预定页面
 * 
 */
toOrder:(e)=>{
  wx.getStorage({
    key:'user',
    success:function(){
      // console.log(e.currentTarget.dataset.proid)
      wx.navigateTo({
        url:'/pages/order/order?proid='+e.currentTarget.dataset.proid
      })
    },
    fail:function(){
      wx.showToast({
        title: '账号异常',
        icon: 'error',
        duration: 2000
      })
    }
  })
},

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(option) {
     
    var that = this;
    
    wx.request({
      url: that.data.httpurl + "project/byId",
      data: {
        id:option.id
      },
      success:function(res) {
        var good = res.data.data.flag
        if(good == "true") {
          that.setData({
            project: res.data.data,
            flag:true
          })
        }else {
          that.setData({
            project: res.data.data,
            flag:false
          })
        }
        
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