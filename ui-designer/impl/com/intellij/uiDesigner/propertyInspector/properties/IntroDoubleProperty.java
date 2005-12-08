package com.intellij.uiDesigner.propertyInspector.properties;

import com.intellij.uiDesigner.XmlWriter;
import com.intellij.uiDesigner.propertyInspector.IntrospectedProperty;
import com.intellij.uiDesigner.propertyInspector.Property;
import com.intellij.uiDesigner.propertyInspector.PropertyEditor;
import com.intellij.uiDesigner.propertyInspector.PropertyRenderer;
import com.intellij.uiDesigner.propertyInspector.editors.DoubleEditor;
import com.intellij.uiDesigner.propertyInspector.renderers.DoubleRenderer;

import java.lang.reflect.Method;

import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Katilin
 * @author Vladimir Kondratyev
 */
public final class IntroDoubleProperty extends IntrospectedProperty{
  private final DoubleRenderer myRenderer;
  private final DoubleEditor myEditor;

  public IntroDoubleProperty(final String name, final Method readMethod, final Method writeMethod){
    super(name, readMethod, writeMethod);
    myRenderer = new DoubleRenderer();
    myEditor = new DoubleEditor();
  }

  @NotNull
  public Property[] getChildren(){
    return EMPTY_ARRAY;
  }

  @NotNull
  public PropertyRenderer getRenderer(){
    return myRenderer;
  }

  public PropertyEditor getEditor(){
    return myEditor;
  }

  public void write(final Object value, final XmlWriter writer){
    final Double aDouble = (Double)value;
    writer.addAttribute("value", aDouble.toString());
  }
}
