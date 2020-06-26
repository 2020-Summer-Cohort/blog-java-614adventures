package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeControllerTest {
    ActivityRepository mockActivities = mock(ActivityRepository.class);
    HashtagRepository mockHashtags = mock(HashtagRepository.class);
    HomeController underTest = new HomeController(mockActivities, mockHashtags);

    @Test
    public void shouldReturnHomeTemplate() {
        Model model = mock(Model.class);
        String templateName = underTest.showHome(model);
        assertThat(templateName).isEqualTo("home-template");
    }

    @Test
    public void shouldShowAllActivities() {
        Model model = mock(Model.class);
        underTest.showHome(model);
        verify(mockActivities).findAll();
    }

    @Test
    public void shouldShowAllHashtags() {
        Model model = mock(Model.class);
        underTest.showHome(model);
        verify(mockHashtags).findAll();
    }
}

