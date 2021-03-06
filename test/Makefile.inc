#
# Include paths
#
COMMON_TEST_INCLUDES = \
    -I$(top_srcdir)/test/common \
    -I$(top_srcdir)/test/googletest-release-1.8.0/googlemock/include \
    -I$(top_srcdir)/test/googletest-release-1.8.0/googletest/include

COMMON_BASE_TEST_LIBS = \
	$(top_builddir)/libredex.la \
	$(BOOST_FILESYSTEM_LIB) \
	$(BOOST_SYSTEM_LIB) \
	$(BOOST_REGEX_LIB) \
	$(BOOST_PROGRAM_OPTIONS_LIB) \
	$(BOOST_THREAD_LIB) \
	-lpthread \
	-ldl

# Libs.
COMMON_TEST_LIBS = \
    $(COMMON_BASE_TEST_LIBS) \
	$(top_builddir)/test/libgtest_main.la

COMMON_MOCK_TEST_LIBS = \
    $(COMMON_BASE_TEST_LIBS) \
	$(top_builddir)/test/libgtest.la \
	$(top_builddir)/test/libgmock_main.la
