# BasicList
리스트뷰 사용법
## 학습목표
### ListView + BaseAdapter

* BaseAdapter 를 커스터마이징해서 ListView 세팅할 수 있어야 합니다

#### ListView 사용단계

1. ListView 위젯 가져오기
2. Adapter 정의하기
3. ListView 에 Adapter 세팅하기

### RecyclerView

* RecyclerView.Adapter 를 커스터마이징 할 수 있어야 합니다.

#### RecyclerView 사용단계

1. Recycler 위젯 가져오기
2. Adapter 정의하기
3. Recycler 에 Adapter 세팅하기
4. Recycler 에 LayoutManger 세팅하기

### CardView

* xmlns 로 namespace를 정의해서 cardview 속성을 사용할 수 있어야 합니다.

* cardview 에 onclick 이벤트를 정의할 수 있어야 합니다.


---------------------------------------



![](http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile28.uf.tistory.com%2Fimage%2F2274833D57472A0A22ED1D)
### **ViewHolder**
> ViewHolder란, 이름 그대로 뷰들을 홀더에 꼽아놓듯이 보관하는 객체를 말합니다. 각각의 Row를 그려낼 때 그 안의 위젯들의 속성을 변경하기 위해 findViewById를 호출하는데 이것의 비용이 큰것을 줄이기 위해 사용합니다.
>  주로 ListView의 퍼포먼스를 높이기 위하여 사용됩니다.
>  예를 들어, 리스트가 1000개 있다고 생각해보겠습니다.
 왼쪽과 같은 리스트 뷰는 TextView 3개로 구성되어 있습니다.
 TextView를 생성하기 위해 매번 findViewById()를 호출해야 할 것이고,
 3000번 호출된다면, 이는 엄청난 성능 오버헤드를 불러오게 됩니다.
 아마 스크롤 내릴 때마다 매우 느린 반응속도를 보일 것입니다.
 이를 해결하기 위해 ViewHolder 패턴이 나타났습니다.

![](http://i2.wp.com/novafactory.net/wp-content/uploads/1/cfile22.uf.1967C1344ECD02F41A1B1B.png?zoom=1.25&resize=380%2C366)

>그래서 아래의 Corret code에서는 Adapter의 이러한 View 재활용을 이용해 View가 null인지를 체크하고,
null일때(아직 화면에 보여진적이 없을때)만 뷰를 inflate해서 생성합니다.
이 경우 조금이라도 화면에 보여지는 뷰까지 합쳐서 한번에 화면에 보여지는 뷰의 갯수는 10개입니다.(0~9)
그리고 이렇게 10개만 View를 inflate해서 만들어 놓은 후 계속해서 재활용해서 사용하는 것이지요.

###**[RecyclerView](http://itmining.tistory.com/12)** 출처 : http://itmining.tistory.com/12

>RecyclerView는 ListView의 문제를 해결하기 위해 개발자에게 더 다양한 형태로 커스터마이징 할 수 있도록 제공되었습니다. RecyclerView와 ListView의 가장 큰 차이점은 Layout Manager와, View Holder 패턴의 의무사용, Item에 대한 뷰의 변형이나 애니메이션할 수 있는 개념이 추가되었습니다.

> **<장점>**
> - ViewHolder패턴을 적용하여 뷰를 재활용
> - layout에 유연하게 대처
> - Swipe를 이용하여 직관적인 Refresh UI구조 설계가능
> - 대용량 데이터를 효율적으로 관리가능
> - position에 따라 한 리스트 내에서 다양한 뷰를 표현가능(MultiView)

> **<단점>**
> - 기존 ListView에 비해 생성코드가 복잡함
> - 기본적으로 itemClick 리스너가 존재하지 않고 프로그래머가 직접 인터페이스를 개발하여야 함


> **주요 클래스**

> - Adapter ? 기존의 ListView에서 사용하는 Adapter와 같은 개념으로 데이터와 아이템에 대한 View생성
> - ViewHolder ? 재활용 View에 대한 모든 서브 뷰를 보유
> - LayoutManager ? 아이템의 항목을 배치
> - ItemDecoration ? 아이템 항목에서 서브뷰에 대한 처리
> - ItemAnimation ? 아이템 항목이 추가, 제거되거나 정렬될때 애니메이션 처리

> **Adapter**
> 
> - onCreateViewHolder(ViewGroup parent, int viewType)  : 뷰 홀더를 생성하고 뷰를 붙여주는 부분입니다.
> -  onBindViewHolder(ListItemViewHolder holder, int position) : 재활용 되는 뷰가 호출하여 실행되는 메소드, 뷰 홀더를 전달하고 어댑터는 position 의 데이터를 결합시킵니다.
> - getItemCount( ) : 데이터의 개수 반환

> ![](http://cfile9.uf.tistory.com/image/25460B385783314C011E94)
> 리사이클러뷰에서는 수평 스크롤 또한 지원합니다. 뿐만 아니라 더 다양한 타입의 리스트들을 지원하고, 커스텀 할 수 있도록 해줍니다. 많은 타입의 리스트를 사용하기 위해선 RecyclerView.LayoutManager 클래스를 사용하면 됩니다. 리사이클러 뷰는 아래와 같은 3가지의 미리 정의된 Layout Managers를 제공합니다.

> - LinearLayoutManager : 리사이클러 뷰에서 가장 많이 쓰이는 레이아웃으로 수평, 수직 스크롤을 제공하는 리스트를 만들 수 있습니다.
> -  StaggeredGridLayouManager : 이 레이아웃을 통해 뷰마다 크기가 다른 레이아웃을 만들 수 있습니다. 마치 Pinterest 처럼요.
> - GridLayoutManager : 여러분의 사진첩 같은 격자형 리스트를 만들 수 있습니다.

> ![](http://cfile24.uf.tistory.com/image/2439F7475782AA0B2AF63C)
> 
> - 리사이클러 뷰에서는 RecyclerView.ItemAnimator 클래스를 통해 애니메이션을 핸들링 할 수 있게되었죠. 이 클래스를 통해서 아이템 삽입, 삭제, 이동에 대한 커스터마이징이 가능하고, 또한 DefaultItemAnimator가 제공되므로 커스터마이즈가 필요 없이 사용할 수도 있습니다.

> #####**결론**
>  리사이클러 뷰는 리스트 뷰에 비해 상당히 기능적 커스터마이징에 중점을 두고 있습니다. 리스트 뷰에 비해 조금 어려울 수 있지만, 사용자에게 앱에 대한 연결성을 유지시켜주는 머터리얼 디자인에 대한 요구를 충족시키는 복잡한 그리드나 리스트에 아주 유용하게 쓰일 수 있겠죠. 다음 포스팅에선 유연성과 확장성이 향상된 Recycler View를 사용해보도록 하겠습니다.

###**[CardView](http://swalloow.tistory.com/72)**
> 안드로이드 CardView 는 support.v7.widget 에 속한 라이브러리 입니다.
 리스트 뷰를 보여줄 때 카드 레이아웃을 사용한 형태를 많이 구현했습니다.
 하지만, 직접 그림자도 그려야 하고, 틀을 만들어야 하는 어려움이 존재했습니다.
 이를 해결하기 위해 SDK 21버전부터 CardView가 추가되었습니다.

> CardView는 FrameLayout 클래스를 확장한 형태입니다.
 둥근 모서리, 배경과 그림자가 추가된 FrameLayout 이라고 보시면 됩니다.

> ![](http://img1.daumcdn.net/thumb/R960x0/?fname=http%3A%2F%2Fcfile21.uf.tistory.com%2Fimage%2F25078F4657474A7E157355)

> 위 그림의 경우, 하나의 RecyclerView 내부에 CardView가 들어가 있고, 
또 그 안에 RelativeLayout이 있으며 TextView와 ImageView가 들어있는 형태입니다.


> [CardView 설명](http://blog.naver.com/PostView.nhn?blogId=scw0531&logNo=220820114946&parentCategoryNo=&categoryNo=8&viewDate=&isShowPopularPosts=false&from=postView)
