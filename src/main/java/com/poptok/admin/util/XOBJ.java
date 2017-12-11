package com.poptok.admin.util;

//*******************************************************************************************
//XOBJ CLASS
//*******************************************************************************************
/**
*
* @author jsimms
*/
/*
  XOBJ is the base object that houses the value. XREF and XOUT are classes that
  internally use XOBJ. The classes XOBJ, XREF, and XOUT have methods that allow
  the object to be used as XREF or XOUT parameter; This is important, because
  objects of these types are interchangeable.

  See Method:
     XXX.Ref()
     XXX.Out()

  The below example shows how to use XOBJ, XREF, and XOUT;
  //
  // Reference parameter example
  //
  void AddToTotal(int a, XREF<Integer> Total)
  {
     Total.Obj.Value += a;
  }

  //
  // out parameter example
  //
  void Add(int a, int b, XOUT<Integer> ParmOut)
  {
     ParmOut.Obj.Value = a+b;
  }

  //
  // XOBJ example
  //
  int XObjTest()
  {
     XOBJ<Integer> Total = new XOBJ<>(0);
     Add(1, 2, Total.Out());    // Example of using out parameter
     AddToTotal(1,Total.Ref()); // Example of using ref parameter
     return(Total.Value);
  }
*/

public class XOBJ<T> {

    public T Value;

    public  XOBJ() {

    }

    public XOBJ(T value) {
        this.Value = value;
    }

    //
    // Method: Ref()
    // Purpose: returns a Reference Parameter object using the XOBJ value
    //
    public XREF<T> Ref()
    {
        XREF<T> ref = new XREF<T>();
        ref.Obj = this;
        return(ref);
    }

    //
    // Method: Out()
    // Purpose: returns an Out Parameter Object using the XOBJ value
    //
    public XOUT<T> Out()
    {
        XOUT<T> out = new XOUT<T>();
        out.Obj = this;
        return(out);
    }

    //
    // Method get()
    // Purpose: returns the value
    // Note: Because this is combersome to edit in the code,
    // the Value object has been made public
    //
    public T get() {
        return Value;
    }

    //
    // Method get()
    // Purpose: sets the value
    // Note: Because this is combersome to edit in the code,
    // the Value object has been made public
    //
    public void set(T anotherValue) {
        Value = anotherValue;
    }

    @Override
    public String toString() {
        return Value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return Value.equals(obj);
    }

    @Override
    public int hashCode() {
        return Value.hashCode();
    }
}