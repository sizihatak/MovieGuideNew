package com.project.sizihatak.movieguidenew.ui.main;

import android.os.Bundle;
import com.anadeainc.rxbus.Bus;
import com.project.sizihatak.movieguidenew.data.AppDataManager;
import com.project.sizihatak.movieguidenew.data.network.model.Movie;
import com.project.sizihatak.movieguidenew.ui.main.event.OpenMovieDetailsEvent;
import io.reactivex.disposables.CompositeDisposable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) public class MainPresenterTest {

  @Mock MainContract.View mvpView;

  @Mock Bus bus;

  @Mock Movie movie;

  @Mock OpenMovieDetailsEvent openMovieDetailsEvent;

  @Mock AppDataManager appDataManager;

  @InjectMocks @Spy MainPresenter presenter =
      new MainPresenter(bus, new CompositeDisposable(), appDataManager);

  @Test public void onEvent() throws Exception {
    when(openMovieDetailsEvent.getMovie()).thenReturn(movie);

    presenter.onEvent(openMovieDetailsEvent);

    verify(mvpView).showBackArrow();
    verify(mvpView).openMoviesDetailsScreen(any(Bundle.class));
  }

  @Test public void onBackClick() throws Exception {
    presenter.onBackClick();

    verify(mvpView).hideBackArrow();
    verify(mvpView).onPreviousScreen();
  }
}