# TDD-GildedRose

A TDD exercise.

## 需求描述

“镶金玫瑰”！这是一家魔兽世界里的小商店。出售的商品也都是高质量的。但不妙的是，随着商品逐渐接近保质期，它们的质量也不断下滑。现邀请你开发一个IT系统，从而能够在每过去一天后，对商店中商品的信息做出对应的更新。

首先，简单介绍一下我们的商品特性：

1. 所有商品都有一个SellIn值，这是商品距离过期的天数，最好在这么多天之内卖掉
2. 所有商品都有一个Quality值，代表商品的价值
3. 商品的SellIn值和Quality值，它们每天会发生变化，但是会有特例

商品的价格规则说明如下：

1. 商品每过一天价值会下滑1点 ，一旦过了保质期，价值就以双倍的速度下滑
2. 商品的价值永远不会小于0，也永远不会超过50
3. 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高
4. 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑
5. 后台门票（Backstage pass）和陈年干酪（Aged Brie）有相似之处：
   - 越接近演出日，商品价值Quality值反而上升
   - 在演出前10天，价值每天上升2点
   - 演出前5天，价值每天上升3点
   - 一旦过了演出日，价值就马上变成0

## Tasking

1. regular

   - 前一天：sellIn > 0 且 0<quality<50  ->  今天：sellIn -1，quality-1
   - 前一天：sellIn > 0 且 quality = 0 -> 今天：sellIn - 1，quality = 0
   - 前一天：sellIn = 0 且 0<quality<50 -> 今天：sellIn -1  quality-2
   - 前一天：sellIn = 0 且 quality = 1 -> 今天：sellIn - 1，quality = 0

2. Aged Brie    
3. Sulfuras
4. Backstage pass

