# English | [中文](https://github.com/yanyusong/Y_DividerItemDecoration/blob/master/README_CN.md)

## Y_DividerItemDecoration 

A generic RecyclerView divider that supports LinearLayoutManager and GridViewLayoutManager. As long as you can describe the situation for  the four directions(left、top、right、bottom) of each position , in principle, support any LayoutManager.

![LinearLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-17.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim)  ![普通GridViewLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-30.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim) ![异形GridViewLayoutManager](http://ofc92njab.bkt.clouddn.com/Screenshot_2017-04-10-14-02-39.png?imageView2/0/w/500/h/1000/format/jpg/q/75|imageslim)
## Features
* LinearLayoutManager and GridViewLayoutManager are both supported
* Customize the width and color of the divider
* Flexibly control whether need show divider of the four directions(left、top、right、bottom) of each item  or not

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

Create an object to implement the abstract class Y_DividerItemDecoration. In the getItemSidesIsHaveOffsets (int itemPosition) method, you can decide whether need show divider for the four directions(left、top、right、bottom) of the item of position.


```
    class DividerItemDecoration extends Y_DividerItemDecoration {

        public DividerItemDecoration(Context context, int lineWidthDp, @ColorInt int colorRGB) {
            super(context, lineWidthDp, colorRGB);
        }

        @Override
        public boolean[] getItemSidesIsHaveOffsets(int itemPosition) {
            //clockwise order : left, top, right, bottom
            boolean[] isOffset = {false, false, false, true};//only show the divider of bottom by default
            return isOffset;
        }
    }
    
```
    
### Step2

Add divider to RecyclerView ,And pass the width and color of the divider, width unit must be dp, color format must be 0xAARRGGBB,such as 0xff6c6c6c.

```
recyclerView.addItemDecoration(new DividerItemDecoration(this, 6, 0xff6c6c6c));

```

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


