# [English](https://github.com/yanyusong/Y_DividerItemDecoration/blob/master/README.md) | 中文

## Y_DividerItemDecoration 

一个通用的RecyclerView的分割线，支持LinearLayoutManager和GridLayoutManager。只要你能描述清楚每个position上下左右分割线的情况，原则上支持任意LayoutManager

![LinearLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-17.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim)  ![普通GridLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-30.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim) ![异形GridLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-39.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim)
## Features
* LinearLayoutManager和GridLayoutManager通用
* 自定义分割线的宽度和颜色
* 灵活控制RecyclerView每个条目left、top、right、bottom的分割线的显示与否

## Download

### Gradle

```
compile 'com.yanyusong.y_divideritemdecoration:y_divideritemdecoration:1.0
```

### Maven

```
<dependency>
  <groupId>com.yanyusong.y_divideritemdecoration</groupId>
  <artifactId>y_divideritemdecoration</artifactId>
  <version>1.0</version>
  <type>pom</type>
</dependency>
```

## Usage

### Step1

新建一个对象实现抽象类 Y\_DividerItemDecoration ，在getItemSidesIsHaveOffsets(int itemPosition)中定义在itemPosition时条目的顺时针方向left, top, right, bottom是否需要显示分割线。

```
    class DividerItemDecoration extends Y_DividerItemDecoration {

        public DividerItemDecoration(Context context, int lineWidthDp, @ColorInt int colorRGB) {
            super(context, lineWidthDp, colorRGB);
        }

        @Override
        public boolean[] getItemSidesIsHaveOffsets(int itemPosition) {
            //顺时针顺序:left, top, right, bottom
            boolean[] isOffset = {false, false, false, true};//默认只有bottom显示分割线
            return isOffset;
        }
    }
    
```
    
### Step2

给RecyclerView添加分割线，并传入分割线的width和color，width单位是dp，color必须是包含Alpha和R、G、B的16进值的int值，例如：0xff6c6c6c

```
recyclerView.addItemDecoration(new DividerItemDecoration(this, 6, 0xff6c6c6c));

```

## 交流圈

技术交流QQ群：627374460

或直接扫码加群

![QQ群](http://ofc92njab.bkt.clouddn.com/temp_qrcode_share_627374460.png?imageView2/0/w/300/h/800/format/jpg/q/75|imageslim)

## 赞赏

如果Y_DividerItemDecoration节省了你大量的时间，可否给我买一袋咖啡，让我更加有动力去把它做得更好呢，:blush:，谢谢！

![支付宝](http://ofc92njab.bkt.clouddn.com/1491803495015.jpg?imageView2/0/w/300/h/800/format/jpg/q/75|imageslim)

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


