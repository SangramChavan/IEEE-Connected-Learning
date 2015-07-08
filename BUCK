keystore(
  name = 'debug_keystore',
  store = 'debug.keystore',
  properties = 'debug.keystore.properties',
)

android_resource(
  name = 'res',
  res = 'src/main/res',
  package = 'org.ieee.connected.learning',
  visibility = ['//rebound-android-playground:src'],
)

android_library(
  name = 'src',
  srcs = glob(['src/main/java/**/*.java']),
  deps = [
    ':res',
    '//rebound-core:src',
    '//rebound-android:src',
  ],
)

android_binary(
  name = 'bin',
  manifest = 'src/main/AndroidManifest.xml',
  target = 'Google Inc.:Google APIs:19',
  keystore = ':debug_keystore',
  deps = [
    ':res',
    ':src',
  ],
)

project_config(
  src_target = ':bin',
  src_roots = ['src/main/java'],
)
