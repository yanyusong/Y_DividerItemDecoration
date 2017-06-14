

## Y_DividerItemDecoration 

一个通用的RecyclerView的分割线，支持LinearLayoutManager和GridLayoutManager。只要你能描述清楚每个position上下左右分割线的情况，原则上支持任意LayoutManager

![图1 LinearLayoutManager](https://user-gold-cdn.xitu.io/2017/6/14/6c979a19471443841aa4cfbfc1f7ff3f?imageView2/0/w/500/h/1000/format/jpg/q/90|imageslim)


![图2 大分割线GridViewLayoutManager](https://user-gold-cdn.xitu.io/2017/6/14/626b8aced50a6439ab3ae4194e6f6ea0?imageView2/0/w/500/h/1000/format/jpg/q/90|imageslim)


![图2 普通GridViewLayoutManager](https://user-gold-cdn.xitu.io/2017/6/14/4996020282b47b8a74208a7d192b37cc?imageView2/0/w/500/h/1000/format/jpg/q/90|imageslim)


![图3 异型GridViewLayoutManager](https://user-gold-cdn.xitu.io/2017/6/14/45ac2f0407bc3ac4975a4369f2382459?imageView2/0/w/500/h/1000/format/jpg/q/90|imageslim)
## Features
- LinearLayoutManager和GridViewLayoutManager通用
- 以每个item的上、下、左、右每条边为控制单位
- 可以单独控制每边是否显示
- 可以单独控制每边的颜色
- 可以单独控制每边的宽度
- 可以单独控制每边的 startPadding 和 endPadding

## Usage

### Step 1
将依赖加入你项目的build.gradle中:

```
compile 'com.yanyusong.y_divideritemdecoration:y_divideritemdecoration:2.0'
```

### Step 2
新建一个对象实现抽象类 Y_DividerItemDecoration ，在 getDivider(int itemPosition) 中定义在itemPosition时条目的分割线情况，有无、颜色、宽度、startpadding 和 endpadding 。

```
    private class DividerItemDecoration extends Y_DividerItemDecoration {

        private DividerItemDecoration(Context context) {
            super(context);
        }

        @Override
        public Y_Divider getDivider(int itemPosition) {
            Y_Divider divider = null;
            switch (itemPosition % 2) {
                case 0:
                    //每一行第一个显示rignt和bottom
                    divider = new Y_DividerBuilder()
                            .setRightSideLine(true, 0xff666666, 10, 0, 0)
                            .setBottomSideLine(true, 0xff666666, 20, 0, 0)
                            .create();
                    break;
                case 1:
                    //第二个显示Left和bottom
                    divider = new Y_DividerBuilder()
                            .setLeftSideLine(true, 0xff666666, 10, 0, 0)
                            .setBottomSideLine(true, 0xff666666, 20, 0, 0)
                            .create();
                    break;
                default:
                    break;
            }
            return divider;
        }
    }
```
    
### Step 3

给RecyclerView添加刚才实现的ItemDecoration

```
 recyclerView.addItemDecoration(new DividerItemDecoration(this));
```
## 赞赏

如果Y_DividerItemDecoration节省了你大量的时间，可否给我买一袋咖啡，让我更加有动力去把它做得更好呢，:blush:，谢谢！

![支付宝](https://user-gold-cdn.xitu.io/2017/6/14/48365047622b886792252d664702de31)

## License

```
   Copyright  2017  yanyusong
   
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```


