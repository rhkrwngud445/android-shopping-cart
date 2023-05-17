# android-shopping-cart

## Step1

- [x] 사용자는 상품 목록의 상품을 장바구니에 추가할 수 있다.
    - [x] 상품 목록은 RecyclerView에 GridLayoutManager를 설정하여 구현한다.
    - [x] 상품을 클릭하면 상품 상세로 이동한다.
    - [x] 상품 상세에서 장바구니에 상품을 담을 수 있다.
    - [x] 장바구니에서 원하는 상품을 삭제할 수 있다.
    - [x] 최근 본 상품이 있는 경우 상품 목록 상단에서 10개까지 확인할 수 있다.
- [x] 툴바를 추가한다.
    - [x] 상품 목록 화면에서 장바구니 버튼을 누르면 장바구니 화면으로 이동한다.
    - [x] 장바구니 화면에서 뒤로가기 버튼을 누르면 상품 목록 화면으로 이동한다.
    - [x] 제품 상세 화면에서 닫기 버튼을 누르면 상품 목록 화면으로 이동한다.
- [x] 앱이 종료돼도 최근 본 상품 목록과 장바구니 데이터는 유지돼야 한다.

## Step2

- [ ] 목록 뷰에 데이터 로딩 전략을 적용한다.
    - [ ] 상품 목록에서 더보기 버튼을 눌러 추가 로드할 수 있다. (20개 기준)
    - [ ] 장바구니 목록은 페이지네이션이 되어야 한다. (5개 기준)

## Step3

- [ ] 장바구니
    - [ ] 장바구니 화면에서 상품 수량을 선택할 수 있다.
        - [ ] 각 아이템에서 가격의 합이 출력된다.
    - [ ] 장바구니의 총 가격 합을 확인할 수 있다.
        - [ ] 선택된 총 가격합을 계산한다.
        - [ ] 전체 버튼을 누를 시 해당 페이지의 전체 목록이 선택된다.
    - [ ] 주문하기 오른쪽에 상품 종류의 수를 출력한다.
    - [ ] 각 아이템에서 장바구니에 포함할 지 여부를 선택할 수 있다.

- [ ] 쇼핑
    - [ ] 장바구니에 담긴 아이템 갯수를 볼 수 있다.
    - [ ] 아이템의 +버튼을 누르면 상품 갯수를 선택할 수 있다.

- [ ] 상품 상세보기
    - [ ] 마지막으로 본 상품을 볼 수 있다.
        - [ ] 클릭 시 해당 상품 화면으로 넘어간다.
    - [ ] 장바구니 담기 클릭시 다이아로그가 나온다.
        - [ ] 상품 갯수를 조절할 수 있다.
