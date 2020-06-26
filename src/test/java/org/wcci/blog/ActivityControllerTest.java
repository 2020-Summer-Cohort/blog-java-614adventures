package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ActivityControllerTest {
    ActivityStorage mockStorage = mock(ActivityStorage.class);
    ActivityController underTest = new ActivityController(mockStorage);

    @Test
    public void shouldReturnActivityTemplate() {
        Model model = mock(Model.class);
        String templateName = underTest.showSingleActivity("Theater", model);
        assertThat(templateName).isEqualTo("activity-template");

    }

    @Test
    public void shouldShowActivityContent() {
        Model model = Mockito.mock(Model.class);
        underTest.showSingleActivity("Theater", model);
        verify(mockStorage).findActivityByName("Theater");
        verify(mockStorage).getAllActivities();
    }

    @Test
    public void shouldAddActivityToModel() {
        Model model = Mockito.mock(Model.class);
        Activity testActivity = new Activity("Test Activity");
        when(mockStorage.findActivityByName("Theater")).thenReturn(testActivity);
        underTest.showSingleActivity("Theater", model);
        verify(model).addAttribute("activity", testActivity);
    }
}


