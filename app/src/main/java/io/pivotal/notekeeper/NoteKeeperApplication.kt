package io.pivotal.notekeeper

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import io.pivotal.notekeeper.note.NoteService
import io.pivotal.notekeeper.note.HardCodedNoteService

//@Component(modules = [AndroidInjectionModule::class, AppModule::class])
//interface AppComponent
//
//@Module
//class AppModule (){
//    companion object {
//        @JvmStatic
//        @Provides
//        fun provideNoteService(): NoteService = HardCodedNoteService()
//    }
//}

open class NoteKeeperApplication: Application() {
    open var noteService: NoteService = HardCodedNoteService()
}