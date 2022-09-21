// pages/technicianx/technicianx.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
      httpurl:'http://localhost:82/',
      imageurl:'http://localhost:82/static/',
      technicians:[]
  },
/**
 * 跳转到技师详情页
 */

toTechDetails:function(e) {
  console.log(e)
  wx.navigateTo({
    url:'/pages/thchDetails/thchDetails?techid='+ e.currentTarget.dataset.id
  })
// }
},
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {
    var that = this;
     wx.request({
       url: that.data.httpurl + 'technician/getAll',
       success:(res)=>{
         if(res.data.code == 0){
           that.setData({
             technicians: res.data.data
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