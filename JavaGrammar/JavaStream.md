# ✅ Java Stream

## Stream ? (흐름)
* 자바 8에서 추가한 스트림(Streams)은 람다를 활용할 수 있는 기술 중 하나
* 자바 8 이전에는 배열 또는 컬렉션 인스턴스를 다루는 방법은 for 또는 foreach 문을 돌면서 요소 하나씩을 꺼내서 다루는 방법을 사용
* 배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다.
    * 배열과 컬렉션을 함수형으로 처리할 수 있다.
## Stream 과정
* 생성하기
    * 배열 / 컬렉션 / 빈 스트림
    * Stream.builder() / Stream.generate() / Stream.iterate()
    * 기본 타입형 / String / 파일 스트림
    * 병렬 스트림 / 스트림 연결
* 가공하기
    * Filtering
    * Mapping
    * Sorting
    * Iterating
* 결과생성
    * Calculating
    * Reduction
    * Collecting
    * Matching
    * Iterating
 * 전체  -> 맵핑 -> 필터링 1..2.. -> 결과 생성 -> 결과물
## 생성하기
* 스트림은 배열 또는 컬렉션 인스턴스를 이용해서 생성
    * 배열 스트림 : Arrays.stream
    ```
    String[] arr = new String[]{"a", "b", "c"};
    Stream<String> stream = Arrays.stream(arr);
    Stream<String> streamOfArrayPart = 
    Arrays.stream(arr, 1, 3);
    ```
   * 컬렉션 스트림 : 인터페이스에 추가된 디폴트 메소드 stream 을 이용
    ```
    public interface Collection<E> extends Iterable<E> {
        default Stream<E> stream() {
            return StreamSupport.stream(spliterator(), false);
        } 
        // ...
    }
    ```
    ```
    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> stream = list.stream();
    Stream<String> parallelStream = list.parallelStream(); 
    ```
   * 비어있는 스트림 : 빈 스트림은 요소가 없을 때 null 대신 사용 가능
    ```
    public Stream<String> streamOf(List<String> list) {
        return list == null || list.isEmpty() 
        ? Stream.empty() 
        : list.stream();
    }
    ```
   * Stream.builder() : 직접 원하는 값을 넣을 수 있다. build 메소드로 리턴
    ```
    Stream<String> builderStream = 
        Stream.<String>builder()
            .add("Java").add("Spring").add("Bean")
            .build(); // [Java, Spring, Bean]
    ```
   * Stream.generate() : Supplier<T> 에 해당하는 람다로 값을 넣을 수 있습니다.
    ```
    public static<T> Stream<T> generate(Supplier<T> s) { ... }
       Stream<String> generatedStream = 
           Stream.generate(() -> "gen").limit(5); //크기 제한 필수
    ```
   * Stream.iterate() : 초기값과 해당 값을 다루는 람다를 이용해 스트림에 들어갈 요소를 만든다.
    ```
    Stream<Integer> iteratedStream = 
        Stream.iterate(30, n -> n + 2).limit(5); // 크기 제한 필수
    ```
   * 기본 타입형 스트림 : 제네릭을 사용 안하고 직접적으로 타입 스트림을 다룸
    ```   
    IntStream intStream = IntStream.range(1, 5); // [1, 2, 3, 4]
    LongStream longStream = LongStream.rangeClosed(1, 5); // [1, 2, 3, 4, 5]
    Stream<Integer> boxedIntStream = IntStream.range(1, 5).boxed();
    // 제네릭을 사용하지 않기 때문에 불필요한 오토박싱(auto-boxing)이 일어나지 않음
    // 필요한 경우 boxed 메소드를 이용해서 박싱(boxing)할 수 있습니다.
    cf)난수 클래스로 스트림 만들수 있다.
    DoubleStream doubles = new Random().doubles(3);
    ```
   * 파일 스트림 : 자바 IO 의 Files 클래스의 lines 메소드는 해당 파일의 각 라인을 스트링 타입의 스트림으로 만들어준다.(IO : 스트림 방식 / NIO : 채널 방식)
    ```
    Stream<String> lineStream = 
        Files.lines(Paths.get("file.txt"), 
        Charset.forName("UTF-8"));
    ```
   * 병렬 스트림 : 각각의 스레드에서 처리할 수 있도록 스트림 요소를 여러 청크로 분할한 스트림
    ```
    // 병렬 스트림 생성
    Stream<Product> parallelStream = productList.parallelStream();

    // 병렬 여부 확인
    boolean isParallel = parallelStream.isParallel();
   
    // 배열을 이용한 병렬 스트림 생성
    Arrays.stream(arr).parallel();
   
    // 배열이 아닌 경우 parallel 메소드를 이용하여 처리
    IntStream intStream = IntStream.range(1, 150).parallel();
    boolean isParallel = intStream.isParallel();
    ```
    * 연결하기 : Stream.concat 메소드를 이용해 두 개의 스트림을 연결해서 새로운 스트림을 만들어낼 수 있다.
    ```
    Stream<String> stream1 = Stream.of("Java");
    Stream<String> stream2 = Stream.of("Spring");
    Stream<String> concat = Stream.concat(stream1, stream2);
    // [Java, Spring]
    ```
 ## 가공하기
 * API 를 이용해서 내가 원하는 것만 뽑아낼 수 있다. 
 * 가공 단계를 중간 작업(intermediate operations)이라고 한다. 
 * 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(chaining) 작성할 수 있다.
    ```
    List<String> names = Arrays.asList("Eric", "Elena", "Java");
    ```
   * Filtering : 스트림 내 요소들을 하나씩 평가해서 걸러내는 작업
    ```
    Stream<T> filter(Predicate<? super T> predicate);
    // 예시
    Stream<String> stream = 
        names.stream()
        .filter(name -> name.contains("a"));
    ```
   * Mapping : 스트림 내 요소들을 하나씩 특정 값으로 변환, 인자는 람다. 
        * 스트림에 들어가 있는 값이 input 이 되어서 특정 로직을 거친 후 output 이 되어 (리턴되는) 새로운 스트림에 담긴다. 이러한 작업을 맵핑(mapping)이라고 한다.
    ```
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    
    // 예시 대문자로 변환
    Stream<String> stream = 
        names.stream()
        .map(String::toUpperCase);
    // 예시 수량
    Stream<Integer> stream = 
        productList.stream()
        .map(Product::getAmount);
    ```
    ```
    // flatMap
    ```
   * Sorting : Comparator 를 이용
    ```
    Stream<T> sorted();
    Stream<T> sorted(Comparator<? super T> comparator);
   
    // 예시 오름차순
    IntStream.of(14, 11, 20, 39, 23)
        .sorted()
        .boxed()
        .collect(Collectors.toList());
    
    // 예시 역 정렬
    List<String> lang = 
        Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");

    lang.stream()
        .sorted()
        .collect(Collectors.toList());
        // [Go, Groovy, Java, Python, Scala, Swift]

    lang.stream()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
        // [Swift, Scala, Python, Java, Groovy, Go]
    
    // 인자 비교 Comparator 의 compare 
    int compare(T o1, T o2)
    
    // 예시 비교
    lang.stream()
        .sorted(Comparator.comparingInt(String::length))
        .collect(Collectors.toList());
        // [Go, Java, Scala, Swift, Groovy, Python]

    lang.stream()
        .sorted((s1, s2) -> s2.length() - s1.length())
        .collect(Collectors.toList());
        // [Groovy, Python, Scala, Swift, Java, Go]
    ```
   * Iterating : 스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 peek 이 있다. ‘peek’ 은 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer 를 인자로 받는다.
    ```  
    Stream<T> peek(Consumer<? super T> action);
   
    // 예시 
    int sum = IntStream.of(1, 3, 5, 7, 9)
        .peek(System.out::println)
        .sum();
    ```
 ## 결과 생성
 * 가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계
 * 스트림을 끝내는 최종 작업(terminal operations)
     * Calculating  
        * 스트림 API 는 다양한 종료 작업을 제공. 
        * 최소, 최대, 합, 평균 등 기본형 타입으로 결과를 만들어낼 수 있다.
    ```   
    long count = IntStream.of(1, 3, 5, 7, 9).count();
    long sum = LongStream.of(1, 3, 5, 7, 9).sum();
    // 스트림이 비어 있는 경우 count 와 sum 은 0을 출력
    
    // 최소, 최대의 경우에는 표현할 수가 없기 때문에 Optional 을 이용해 리턴
    OptionalInt min = IntStream.of(1, 3, 5, 7, 9).min();
    OptionalInt max = IntStream.of(1, 3, 5, 7, 9).max();
    
    // 스트림에서 바로 ifPresent 메소드를 이용해서 Optional 을 처리
    DoubleStream.of(1.1, 2.2, 3.3, 4.4, 5.5)
        .average()
        .ifPresent(System.out::println);
    ```
     * Reduction(축소)
          * accumulator : 각 요소를 처리하는 계산 로직. 각 요소가 올 때마다 중간 결과를 생성하는 로직.
          * identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴.
          * combiner : 병렬(parallel) 스트림에서 나눠 계산한 결과를 하나로 합치는 동작하는 로직.
    ```   
    // 1개 (accumulator)
    Optional<T> reduce(BinaryOperator<T> accumulator);

    // 2개 (identity)
    T reduce(T identity, BinaryOperator<T> accumulator);

    // 3개 (combiner)
    <U> U reduce(U identity,
    BiFunction<U, ? super T, U> accumulator,
    BinaryOperator<U> combiner);
    ```
     * Collecting
        * Collector 타입의 인자를 받아서 처리
        * Collectors 객체에서 제공
            * Collectors.toList() : 스트림에서 작업한 결과를 담은 리스트로 반환
    ```    
    List<String> collectorCollection =
        productList.stream()
        .map(Product::getName)
        .collect(Collectors.toList());
    ```
      * Collectors.joining() : 스트림에서 작업한 결과를 하나의 스트링으로 이어 붙임
    ```   
    String listToString = 
        productList.stream()
        .map(Product::getName)
        .collect(Collectors.joining());
        
    //세 개의 인자를 받을 수 있다.
    //delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
    //prefix : 결과 맨 앞에 붙는 문자
    //suffix : 결과 맨 뒤에 붙는 문자
    String listToString = 
        productList.stream()
            .map(Product::getName)
            .collect(Collectors.joining(", ", "<", ">"));
    ```
    * Collectors.averageingInt() :숫자 값(Integer value )의 평균(arithmetic mean)
    ```   
    Double averageAmount = 
        productList.stream()
        .collect(Collectors.averagingInt(Product::getAmount));
    ```
     * Collectors.summingInt() : 숫자값의 합(sum)
    ```  
    Integer summingAmount = 
        productList.stream()
        .collect(Collectors.summingInt(Product::getAmount));
    
    // IntStream 으로 바꿔주는 mapToInt 메소드를 사용
    Integer summingAmount = 
        productList.stream()
        .mapToInt(Product::getAmount)
        .sum(); 
    ```
     * Collectors.summarizingInt() : 합계와 평균 
    ```  
    IntSummaryStatistics statistics = 
        productList.stream()
        .collect(Collectors.summarizingInt(Product::getAmount));
    // 개수 getCount()
    // 합계 getSum()
    // 평균 getAverage()
    // 최소 getMin()
    // 최대 getMax()
    ```
     * Collectors.groupingBy() : 특정 조건으로 요소들을 그룹핑
    ```  
    // 받는 인자는 함수형 인터페이스 Function 
    Map<Integer, List<Product>> collectorMapOfLists =
        productList.stream()
        .collect(Collectors.groupingBy(Product::getAmount));
    // 결과는 Map 타입
    ```
     
     * Collectors.partitioningBy() :함수형 인터페이스 Predicate 를 받고. Predicate 는 인자를 받아서 boolean 값을 리턴
    ```  
    Map<Boolean, List<Product>> mapPartitioned = 
        productList.stream()
        .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));
        
    // 결과
    {false=[Product{amount=14, name='orange'}, 
            Product{amount=13, name='lemon'}, 
            Product{amount=13, name='sugar'}], 
    true=[Product{amount=23, name='potatoes'}, 
            Product{amount=23, name='bread'}]}
    ```
     * Collectors.collectingAndThen() : collect 한 이후에 추가 작업이 필요한 경우에 사용할 수 있다. finisher는 collect 를 한 후에 실행할 작업을 의미한다.
    ```  
    public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(
        Collector<T,A,R> downstream,
        Function<R,RR> finisher) { ... }
    // 예시 collect 후 set
    Set<Product> unmodifiableSet = 
        productList.stream()
        .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                            Collections::unmodifiableSet));
    ```
     * Collector.of()
    ```
    ``` 
     * Matching : 매칭은 조건식 람다 Predicate 를 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴
    
    ```   
    // 하나라도 조건을 만족하는 요소가 있는지(anyMatch)
    boolean anyMatch(Predicate<? super T> predicate);
    
    // 모두 조건을 만족하는지(allMatch)
    boolean allMatch(Predicate<? super T> predicate);
    
    // 모두 조건을 만족하지 않는지(noneMatch)
    boolean noneMatch(Predicate<? super T> predicate);
    
    // 예시
    List<String> names = Arrays.asList("Eric", "Elena", "Java");

    boolean anyMatch = names.stream()
        .anyMatch(name -> name.contains("a"));
    boolean allMatch = names.stream()
        .allMatch(name -> name.length() > 3);
    boolean noneMatch = names.stream()
        .noneMatch(name -> name.endsWith("s"));
    ```
     * Iterating : foreach 는 요소를 돌면서 실행되는 최종 작업. 보통 System.out.println 메소드를 넘겨서 결과를 출력할 때 사용. 
    ```  
    names.stream().forEach(System.out::println);
    ```