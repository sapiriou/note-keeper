package io.pivotal.notekeeper.note

import java.util.*

class NoteService private constructor() {


    private val zuperText =
"""Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sed leo in augue suscipit euismod. Sed finibus tincidunt lectus, eu dignissim nunc dapibus et. Donec egestas sapien varius fringilla consequat. Sed eget augue leo. Sed facilisis finibus purus quis fringilla. Morbi at mi eu nibh tincidunt ultrices. Aliquam id nisi nec ipsum suscipit mattis vel id nisl. Aliquam in vulputate augue, sit amet eleifend justo. Etiam mi massa, consequat quis aliquet quis, rutrum sit amet enim. Proin id augue at massa suscipit sodales eu in diam. Mauris cursus, augue in suscipit finibus, ex dolor lacinia odio, eget fringilla tortor quam quis elit. Nulla imperdiet nibh ex, a tincidunt odio ullamcorper ac. Aenean metus erat, malesuada a arcu eget, scelerisque laoreet libero.

In tincidunt, urna eget scelerisque ullamcorper, tellus arcu ultrices magna, malesuada lacinia ante elit condimentum neque. Nam finibus leo at ultricies vulputate. Nam ac leo sollicitudin, varius ligula a, gravida elit. Suspendisse lorem enim, dignissim et egestas sit amet, elementum pellentesque nisl. Cras commodo tempus odio, vel egestas nunc ultrices quis. Aliquam imperdiet magna facilisis, dictum risus ac, vehicula tortor. Mauris blandit dolor felis, eu congue turpis volutpat vitae. Fusce consectetur commodo leo in sodales. Maecenas vulputate lobortis nisi porta dictum. Nulla in pretium justo, sed congue leo. Maecenas eleifend consectetur libero a vulputate. Etiam ac erat fermentum, volutpat turpis sit amet, finibus nisl. Integer consequat sapien eget turpis dapibus feugiat. Duis maximus justo metus, vel fringilla enim cursus vel.

Quisque tempor nibh eu nisi iaculis, sed bibendum est placerat. Sed id egestas justo. Praesent lacinia eget dolor vitae consequat. Cras eget facilisis odio. Phasellus lacus diam, pharetra vitae velit vitae, volutpat tristique tortor. Nulla non tristique lectus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.

Donec tempor tempus nisi, at tempus felis efficitur vulputate. In quis velit tellus. In hac habitasse platea dictumst. Nunc elit dui, cursus vel vulputate eu, faucibus non ante. In a cursus enim, vitae maximus sem. Fusce a turpis commodo, consequat sem eget, pellentesque dui. Proin mattis volutpat magna, sagittis commodo mi cursus quis. Nunc efficitur commodo diam in bibendum. Nam eget semper ligula, id ultricies justo. Ut in feugiat nibh. Integer mattis odio in aliquet semper. Nam augue justo, feugiat non gravida sed, mattis non est.

Praesent quis turpis quam. Nulla ultricies bibendum mi, quis tempus arcu varius quis. Morbi ac finibus turpis, in faucibus risus. Nulla sed sagittis felis. Vestibulum quis congue ipsum. Maecenas gravida dictum nibh, rutrum sagittis ligula consequat quis. Nunc pellentesque nisl quis augue viverra malesuada.

"""

    // TODO: use makeSuperContent for text
    val notes: List<Note> = (0..9).map { Note(it, "Title $it", zuperText) }

    private fun makeSuperContent() = zuperText.substring((Random().nextInt(zuperText.length / 2)..200))

    companion object {
        val instance: NoteService by lazy { NoteService() }
    }
}