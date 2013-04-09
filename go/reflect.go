package main

import(
    "fmt"
    "reflect"
    "time"
    "strconv"
)

type Person struct{
    Name string
    Age int
    Hello string
}

func (this *Person) SayName(){
    this.Hello="I am "+this.Name+","+strconv.Itoa(this.Age)+" years old."
}

func main(){
    rt:=1000000
    person:=Person{"Bug",100,""}
    start:=time.Now().UTC().UnixNano()
    for i:=0;i<rt;i++{
        person.SayName()
    }
    cost1:=time.Now().UTC().UnixNano()-start
    start=time.Now().UTC().UnixNano()
    v:=reflect.ValueOf(&person)
    method:=v.MethodByName("SayName")
    none:=[]reflect.Value{}
    for i:=0;i<rt;i++{
        method.Call(none)
    }
    cost2:=time.Now().UTC().UnixNano()-start
    fmt.Println(person.Hello)
    fmt.Println(cost1,cost2)
}
