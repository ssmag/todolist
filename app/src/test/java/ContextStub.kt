import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.IntentSender
import android.content.ServiceConnection
import android.content.SharedPreferences
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.UserHandle
import android.view.Display
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream

class ContextStub: Context() {
    override fun getAssets(): AssetManager {
        TODO("Stub")
    }

    override fun getResources(): Resources {
        TODO("Stub")
    }

    override fun getPackageManager(): PackageManager {
        TODO("Stub")
    }

    override fun getContentResolver(): ContentResolver {
        TODO("Stub")
    }

    override fun getMainLooper(): Looper {
        TODO("Stub")
    }

    override fun getApplicationContext(): Context {
        return this
    }

    override fun setTheme(p0: Int) {
        TODO("Stub")
    }

    override fun getTheme(): Resources.Theme {
        TODO("Stub")
    }

    override fun getClassLoader(): ClassLoader {
        TODO("Stub")
    }

    override fun getPackageName(): String {
        TODO("Stub")
    }

    override fun getApplicationInfo(): ApplicationInfo {
        TODO("Stub")
    }

    override fun getPackageResourcePath(): String {
        TODO("Stub")
    }

    override fun getPackageCodePath(): String {
        TODO("Stub")
    }

    override fun getSharedPreferences(p0: String?, p1: Int): SharedPreferences {
        TODO("Stub")
    }

    override fun moveSharedPreferencesFrom(p0: Context?, p1: String?): Boolean {
        TODO("Stub")
    }

    override fun deleteSharedPreferences(p0: String?): Boolean {
        TODO("Stub")
    }

    override fun openFileInput(p0: String?): FileInputStream {
        TODO("Stub")
    }

    override fun openFileOutput(p0: String?, p1: Int): FileOutputStream {
        TODO("Stub")
    }

    override fun deleteFile(p0: String?): Boolean {
        TODO("Stub")
    }

    override fun getFileStreamPath(p0: String?): File {
        TODO("Stub")
    }

    override fun getDataDir(): File {
        TODO("Stub")
    }

    override fun getFilesDir(): File {
        TODO("Stub")
    }

    override fun getNoBackupFilesDir(): File {
        TODO("Stub")
    }

    override fun getExternalFilesDir(p0: String?): File? {
        TODO("Stub")
    }

    override fun getExternalFilesDirs(p0: String?): Array<File> {
        TODO("Stub")
    }

    override fun getObbDir(): File {
        TODO("Stub")
    }

    override fun getObbDirs(): Array<File> {
        TODO("Stub")
    }

    override fun getCacheDir(): File {
        TODO("Stub")
    }

    override fun getCodeCacheDir(): File {
        TODO("Stub")
    }

    override fun getExternalCacheDir(): File? {
        TODO("Stub")
    }

    override fun getExternalCacheDirs(): Array<File> {
        TODO("Stub")
    }

    override fun getExternalMediaDirs(): Array<File> {
        TODO("Stub")
    }

    override fun fileList(): Array<String> {
        TODO("Stub")
    }

    override fun getDir(p0: String?, p1: Int): File {
        TODO("Stub")
    }

    override fun openOrCreateDatabase(
        p0: String?,
        p1: Int,
        p2: SQLiteDatabase.CursorFactory?,
    ): SQLiteDatabase {
        TODO("Stub")
    }

    override fun openOrCreateDatabase(
        p0: String?,
        p1: Int,
        p2: SQLiteDatabase.CursorFactory?,
        p3: DatabaseErrorHandler?,
    ): SQLiteDatabase {
        TODO("Stub")
    }

    override fun moveDatabaseFrom(p0: Context?, p1: String?): Boolean {
        TODO("Stub")
    }

    override fun deleteDatabase(p0: String?): Boolean {
        TODO("Stub")
    }

    override fun getDatabasePath(p0: String?): File {
        TODO("Stub")
    }

    override fun databaseList(): Array<String> {
        TODO("Stub")
    }

    override fun getWallpaper(): Drawable {
        TODO("Stub")
    }

    override fun peekWallpaper(): Drawable {
        TODO("Stub")
    }

    override fun getWallpaperDesiredMinimumWidth(): Int {
        TODO("Stub")
    }

    override fun getWallpaperDesiredMinimumHeight(): Int {
        TODO("Stub")
    }

    override fun setWallpaper(p0: Bitmap?) {
        TODO("Stub")
    }

    override fun setWallpaper(p0: InputStream?) {
        TODO("Stub")
    }

    override fun clearWallpaper() {
        TODO("Stub")
    }

    override fun startActivity(p0: Intent?) {
        TODO("Stub")
    }

    override fun startActivity(p0: Intent?, p1: Bundle?) {
        TODO("Stub")
    }

    override fun startActivities(p0: Array<out Intent>?) {
        TODO("Stub")
    }

    override fun startActivities(p0: Array<out Intent>?, p1: Bundle?) {
        TODO("Stub")
    }

    override fun startIntentSender(p0: IntentSender?, p1: Intent?, p2: Int, p3: Int, p4: Int) {
        TODO("Stub")
    }

    override fun startIntentSender(
        p0: IntentSender?,
        p1: Intent?,
        p2: Int,
        p3: Int,
        p4: Int,
        p5: Bundle?,
    ) {
        TODO("Stub")
    }

    override fun sendBroadcast(p0: Intent?) {
        TODO("Stub")
    }

    override fun sendBroadcast(p0: Intent?, p1: String?) {
        TODO("Stub")
    }

    override fun sendOrderedBroadcast(p0: Intent?, p1: String?) {
        TODO("Stub")
    }

    override fun sendOrderedBroadcast(
        p0: Intent,
        p1: String?,
        p2: BroadcastReceiver?,
        p3: Handler?,
        p4: Int,
        p5: String?,
        p6: Bundle?,
    ) {
        TODO("Stub")
    }

    override fun sendBroadcastAsUser(p0: Intent?, p1: UserHandle?) {
        TODO("Stub")
    }

    override fun sendBroadcastAsUser(p0: Intent?, p1: UserHandle?, p2: String?) {
        TODO("Stub")
    }

    override fun sendOrderedBroadcastAsUser(
        p0: Intent?,
        p1: UserHandle?,
        p2: String?,
        p3: BroadcastReceiver?,
        p4: Handler?,
        p5: Int,
        p6: String?,
        p7: Bundle?,
    ) {
        TODO("Stub")
    }

    override fun sendStickyBroadcast(p0: Intent?) {
        TODO("Stub")
    }

    override fun sendStickyOrderedBroadcast(
        p0: Intent?,
        p1: BroadcastReceiver?,
        p2: Handler?,
        p3: Int,
        p4: String?,
        p5: Bundle?,
    ) {
        TODO("Stub")
    }

    override fun removeStickyBroadcast(p0: Intent?) {
        TODO("Stub")
    }

    override fun sendStickyBroadcastAsUser(p0: Intent?, p1: UserHandle?) {
        TODO("Stub")
    }

    override fun sendStickyOrderedBroadcastAsUser(
        p0: Intent?,
        p1: UserHandle?,
        p2: BroadcastReceiver?,
        p3: Handler?,
        p4: Int,
        p5: String?,
        p6: Bundle?,
    ) {
        TODO("Stub")
    }

    override fun removeStickyBroadcastAsUser(p0: Intent?, p1: UserHandle?) {
        TODO("Stub")
    }

    override fun registerReceiver(p0: BroadcastReceiver?, p1: IntentFilter?): Intent? {
        TODO("Stub")
    }

    override fun registerReceiver(p0: BroadcastReceiver?, p1: IntentFilter?, p2: Int): Intent? {
        TODO("Stub")
    }

    override fun registerReceiver(
        p0: BroadcastReceiver?,
        p1: IntentFilter?,
        p2: String?,
        p3: Handler?,
    ): Intent? {
        TODO("Stub")
    }

    override fun registerReceiver(
        p0: BroadcastReceiver?,
        p1: IntentFilter?,
        p2: String?,
        p3: Handler?,
        p4: Int,
    ): Intent? {
        TODO("Stub")
    }

    override fun unregisterReceiver(p0: BroadcastReceiver?) {
        TODO("Stub")
    }

    override fun startService(p0: Intent?): ComponentName? {
        TODO("Stub")
    }

    override fun startForegroundService(p0: Intent?): ComponentName? {
        TODO("Stub")
    }

    override fun stopService(p0: Intent?): Boolean {
        TODO("Stub")
    }

    override fun bindService(p0: Intent, p1: ServiceConnection, p2: Int): Boolean {
        TODO("Stub")
    }

    override fun unbindService(p0: ServiceConnection) {
        TODO("Stub")
    }

    override fun startInstrumentation(p0: ComponentName, p1: String?, p2: Bundle?): Boolean {
        TODO("Stub")
    }

    override fun getSystemService(p0: String): Any {
        TODO("Stub")
    }

    override fun getSystemServiceName(p0: Class<*>): String? {
        TODO("Stub")
    }

    override fun checkPermission(p0: String, p1: Int, p2: Int): Int {
        TODO("Stub")
    }

    override fun checkCallingPermission(p0: String): Int {
        TODO("Stub")
    }

    override fun checkCallingOrSelfPermission(p0: String): Int {
        TODO("Stub")
    }

    override fun checkSelfPermission(p0: String): Int {
        TODO("Stub")
    }

    override fun enforcePermission(p0: String, p1: Int, p2: Int, p3: String?) {
        TODO("Stub")
    }

    override fun enforceCallingPermission(p0: String, p1: String?) {
        TODO("Stub")
    }

    override fun enforceCallingOrSelfPermission(p0: String, p1: String?) {
        TODO("Stub")
    }

    override fun grantUriPermission(p0: String?, p1: Uri?, p2: Int) {
        TODO("Stub")
    }

    override fun revokeUriPermission(p0: Uri?, p1: Int) {
        TODO("Stub")
    }

    override fun revokeUriPermission(p0: String?, p1: Uri?, p2: Int) {
        TODO("Stub")
    }

    override fun checkUriPermission(p0: Uri?, p1: Int, p2: Int, p3: Int): Int {
        TODO("Stub")
    }

    override fun checkUriPermission(
        p0: Uri?,
        p1: String?,
        p2: String?,
        p3: Int,
        p4: Int,
        p5: Int,
    ): Int {
        TODO("Stub")
    }

    override fun checkCallingUriPermission(p0: Uri?, p1: Int): Int {
        TODO("Stub")
    }

    override fun checkCallingOrSelfUriPermission(p0: Uri?, p1: Int): Int {
        TODO("Stub")
    }

    override fun enforceUriPermission(p0: Uri?, p1: Int, p2: Int, p3: Int, p4: String?) {
        TODO("Stub")
    }

    override fun enforceUriPermission(
        p0: Uri?,
        p1: String?,
        p2: String?,
        p3: Int,
        p4: Int,
        p5: Int,
        p6: String?,
    ) {
        TODO("Stub")
    }

    override fun enforceCallingUriPermission(p0: Uri?, p1: Int, p2: String?) {
        TODO("Stub")
    }

    override fun enforceCallingOrSelfUriPermission(p0: Uri?, p1: Int, p2: String?) {
        TODO("Stub")
    }

    override fun createPackageContext(p0: String?, p1: Int): Context {
        TODO("Stub")
    }

    override fun createContextForSplit(p0: String?): Context {
        TODO("Stub")
    }

    override fun createConfigurationContext(p0: Configuration): Context {
        TODO("Stub")
    }

    override fun createDisplayContext(p0: Display): Context {
        TODO("Stub")
    }

    override fun createDeviceProtectedStorageContext(): Context {
        TODO("Stub")
    }

    override fun isDeviceProtectedStorage(): Boolean {
        TODO("Stub")
    }
}