var commons = {
    leftQuery: function(param) {
        return new MyPromise(function(resolve, reject) {
            $.ajax({
                type: "get",
                url: preUrl+ "/leftQuery",
                dataType: 'json',
                data: "",
                success: function(res) {
                    if (res.code === 200) {
                        resolve(res.data)
                    } else {
                        throw new Error('有错误')
                    }
                },
                // error: function(res) {
                //     alert("服务异常请稍后再试!")
                // }
            })
        })  
    },
    // 中间地图接口
    upQuery: function(param) {
        return new MyPromise(function(resolve, reject) {
            $.ajax({
                type: "get",
                url: preUrl+ "/upQuery",
                dataType: 'json',
                data: "",
                success: function(res) {
                    if (res.code === 200) {
                        resolve(res.data);
                    } else {
                        throw new Error('有错误')
                    }
                },
                // error: function(res) {
                //     alert("服务异常请稍后再试!")
                // }
            })
        })  
    },
    middlebottomQuery: function(param) {
        return new MyPromise(function(resolve, reject) {
            $.ajax({
                type: "get",
                url: preUrl+ "/downQuery",
                dataType: 'json',
                data: "",
                success: function(res) {
                    if (res.code === 200) {
                        resolve(res.data)
                    } else {
                        throw new Error('有错误')
                    }
                },
                // error: function(res) {
                //     alert("服务异常请稍后再试!")
                // }
            })
        })  
    },
    rightQuery: function(param) {
        return new MyPromise(function(resolve, reject) {
            $.ajax({
                type: "get",
                url: preUrl+ "/rightQuery",
                dataType: 'json',
                data: "",
                success: function(res) {
                    if (res.code === 200) {
                        resolve(res.data)
                    } else {
                        throw new Error('有错误')
                    }
                },
                // error: function(res) {
                //     alert("服务异常请稍后再试!")
                // }
            })
        })  
    }
}