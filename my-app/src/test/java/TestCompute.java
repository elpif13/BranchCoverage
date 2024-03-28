import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestCompute {
  @InjectMocks
  Compute c;

  @Mock
  MessageQueue mq;

  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void messageSizeZero() {
    Mockito.when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(-1,c.countNumberOfOccurrences(""));
  }

  @Test
  public void messageDoesNotContainString() {
    Mockito.when(mq.size()).thenReturn(1); // anything but different than zero
    Mockito.when(mq.contains(anyString())).thenReturn(false);
    c = new Compute(mq);
    assertEquals(0,c.countNumberOfOccurrences("elif"));
  }

  @Test
  public void messageContainsString() {
    Mockito.when(mq.size()).thenReturn(4);
    Mockito.when(mq.contains("elif")).thenReturn(true);
    Mockito.when(mq.getAt(0)).thenReturn("elif");
    Mockito.when(mq.getAt(1)).thenReturn("test1");
    Mockito.when(mq.getAt(2)).thenReturn("elif");
    Mockito.when(mq.getAt(3)).thenReturn("test2");
    c = new Compute(mq);
    assertEquals(2,c.countNumberOfOccurrences("elif"));
  }


}