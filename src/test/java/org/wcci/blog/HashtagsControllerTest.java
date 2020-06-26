package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class HashtagsControllerTest {
    HashtagStorage mockHashtags = mock(HashtagStorage.class);
    HashtagController underTest = new HashtagController(mockHashtags);

    @Test
    public void shouldReturnHashtagTemplate() {
        Model model = mock(Model.class);
        String templateName = underTest.showSingleHashtag("Entertainment", model);
        assertThat(templateName).isEqualTo("hashtag-template");
    }

    @Test
    public void shouldShowHashtagContent() {
        Model model = mock(Model.class);
        underTest.showSingleHashtag("Entertainment", model);
        verify(mockHashtags).findHashtagByName("Entertainment");
    }

    @Test
    public void shouldAddHashtagToModel() {
        Model model = mock(Model.class);
        Hashtag testHashtag = new Hashtag("Test Hashtag");
        when(mockHashtags.findHashtagByName("Entertainment")).thenReturn(testHashtag);
        underTest.showSingleHashtag("Entertainment", model);
        verify(model).addAttribute("hashtag", testHashtag);
    }
}
