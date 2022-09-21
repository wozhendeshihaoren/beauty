// pages/thchDetails/thchDetails.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    httpurl:"http://localhost:82/",
    imageurl:"http://localhost:82/static/",
    technician:{},
    flag: false
  },

/**
 * 点击进行关注
 * @param e 
 */

  toFollow:function(e){
     console.log(e.currentTarget.dataset.thch)
    var that = this;
    wx.request({
      url: that.data.httpurl + 'follow/updateId',
      data:{
        imageURL: e.currentTarget.dataset.thch.imageURL,
        techExplain: e.currentTarget.dataset.thch.techExplain,
        techName: e.currentTarget.dataset.thch.techExplain,
        flag: true,
        tid: e.currentTarget.dataset.thch.id
      },
      success:(res)=> {
        that.setData({
          flag: true
        })
      }
    })
  },

cancelFollow:function(e){
    console.log(e.currentTarget.dataset.tech)
    var that = this;
    wx.request({
      url: that.data.httpurl + 'follow/updateId',
      data:{
        imageURL: e.currentTarget.dataset.tech.imageURL,
        techExplain: e.currentTarget.dataset.tech.techExplain,
        techName: e.currentTarget.dataset.tech.techExplain,
        flag: false,
        tid: e.currentTarget.dataset.tech.id
      },
      success:(res)=> {
        that.setData({
          flag: false
        })
      }
    })
  },
/**
 * 
 * 跳转到预约画面
 */

toOrder:function(e){
  wx.getStorage({
    key:'user',
    success:function(){
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
    var good;
    wx.request({
      url: that.data.httpurl + "technician/byId",
      data: {
        id:option.techid
      },
      success:function(res) {
        good = res.data.data.flag
        
        if( good == 'true'){
          that.setData({
            technician: res.data.data,
            flag: true
          })
        }else {
          that.setData({
            technician: res.data.data,
            flag: false
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